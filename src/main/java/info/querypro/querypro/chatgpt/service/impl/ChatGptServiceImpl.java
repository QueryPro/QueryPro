package info.querypro.querypro.chatgpt.service.impl;

import static info.querypro.querypro.chatgpt.util.ChatGptConstant.AUTHORIZATION;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.BEARER;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.MAX_TOKEN;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.MODEL;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.TEMPERATURE;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.TOP_P;
import static info.querypro.querypro.chatgpt.util.ChatGptConstant.URL;

import java.util.List;
import info.querypro.querypro.chatgpt.dto.request.ChatGptRequestDto;
import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
import info.querypro.querypro.config.OpenAiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
public class ChatGptServiceImpl implements ChatGptService {
    private final OpenAiConfig aiConfig;
    @Override
    public ChatGptResponseDto questionChatGpt(QuestionRequestDto questionRequestDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, BEARER + aiConfig.getKey());

        ChatGptRequestDto chatGptRequestDto = new ChatGptRequestDto(
            MODEL,
            MAX_TOKEN,
            TEMPERATURE,
            List.of(new ChatGptRequestDto.Messages("user", questionRequestDto.getQuestion())),
            TOP_P
        );

        HttpEntity<ChatGptRequestDto> httpEntity =
            new HttpEntity<>(chatGptRequestDto, headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<ChatGptResponseDto> exchange = restTemplate.exchange(
            URL,
            HttpMethod.POST,
            httpEntity,
            ChatGptResponseDto.class
        );

        return exchange.getBody();
    }

}
