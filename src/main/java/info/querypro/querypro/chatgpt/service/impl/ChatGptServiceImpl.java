package info.querypro.querypro.chatgpt.service.impl;

import static info.querypro.querypro.chatgpt.util.ChatGptConstant.AUTHORIZATION;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.BEARER;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.MAX_TOKEN;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.MODEL;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.SESSION_CREATE_URL;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.TEMPERATURE;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.TOP_P;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.URL;

import java.util.ArrayList;
import java.util.List;
import info.querypro.querypro.chatgpt.dto.request.ChatGptRequestDto;
import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
import info.querypro.querypro.config.OpenAiConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ChatGptServiceImpl implements ChatGptService {
    private final OpenAiConfig aiConfig;

    private final Integer QUESTION_COUNT = 50;

    @Override
    public StringBuilder questionChatGpt(QuestionRequestDto questionRequestDto)
        throws JSONException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, BEARER + aiConfig.getKey());

        ChatGptRequestDto chatGptRequestDto = new ChatGptRequestDto(
            MODEL,
            MAX_TOKEN,
            TEMPERATURE,
            List.of(new ChatGptRequestDto.Messages("user", "사용자 이름 : \"임태원\\n" +
                questionRequestDto.getQuestion())),
            TOP_P
        );

        RestTemplate restTemplate = new RestTemplate();

        ChatGptResponseDto body = restTemplate.exchange(
            URL,
            HttpMethod.POST,
            new HttpEntity<>(chatGptRequestDto, headers),
            ChatGptResponseDto.class
        ).getBody();

        StringBuilder sb = new StringBuilder();

        StringBuilder questionBuilder = new StringBuilder();

        sb.append(body.getChoices().get(0).getMessage().getContent());
        questionBuilder.append(
            body.getChoices().get(0).getMessage().getContent().split("Answer:")[0]);
        log.warn("while 문 밖 : {}", body);

        int i = 0;

        while (!body.getChoices().get(0).getFinishReason().equals("stop") || i < QUESTION_COUNT) {
            chatGptRequestDto = new ChatGptRequestDto(

                MODEL,
                MAX_TOKEN,
                TEMPERATURE,
                List.of(new ChatGptRequestDto.Messages("user", "이전 대화 내용을 알려줄게 \n" +
                    "사용자 : " + questionRequestDto.getQuestion() + "\n" +
                    "chat gpt 대답 : " + questionBuilder + "\n" +
                    "대답이 끊겼어 이어서 계속 질문을 1개만 해줘 " +
                    "응답형식은 Question: 질문내용 '\n' Answer: 답변내용")),
                TOP_P
            );

            body = restTemplate.exchange(
                URL,
                HttpMethod.POST,
                new HttpEntity<>(chatGptRequestDto, headers),
                ChatGptResponseDto.class
            ).getBody();

            log.warn("while 문 안 : {}", body);
            sb.append("\n");
            sb.append(body.getChoices().get(0).getMessage().getContent());
            questionBuilder.append("\n");

            String content = body.getChoices().get(0).getMessage().getContent();
            String[] split = content.split("Answer:");
            questionBuilder.append(split[0]);
            questionBuilder.append("\n");
            i++;
        }

        return sb;
    }

}
