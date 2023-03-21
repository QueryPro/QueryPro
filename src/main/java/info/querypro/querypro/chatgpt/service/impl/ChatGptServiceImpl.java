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

    @Override
    public StringBuilder questionChatGpt(QuestionRequestDto questionRequestDto) throws JSONException {
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

        sb.append(body.getChoices().get(0).getMessage().getContent());
        log.warn("while 문 밖 : {}", body);

        while (!body.getChoices().get(0).getFinishReason().equals("stop")) {
            chatGptRequestDto = new ChatGptRequestDto(

                    MODEL,
                    MAX_TOKEN,
                    TEMPERATURE,
                    List.of(new ChatGptRequestDto.Messages("user", "이전 대화 내용을 알려줄게 \n" +
                            "사용자 : " + questionRequestDto.getQuestion() + "\n" +
                            "chat gpt 대답 : " + sb + "\n" +
                            "대답이 끊겼어 이어서 계속 말해줘")),
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
        }

        return sb;
    }

}
