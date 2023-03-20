package info.querypro.querypro.chatgpt.service.impl;

import static info.querypro.querypro.chatgpt.util.ChatGptConstant.*;

import info.querypro.querypro.chatgpt.dto.request.ChatGptRequestDto;
import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
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
public class ChatGptServiceImpl implements ChatGptService {

    @Override
    public ChatGptResponseDto questionChatGpt(QuestionRequestDto questionRequestDto) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(AUTHORIZATION, BEARER + API_KEY);

        ChatGptRequestDto chatGptRequestDto = new ChatGptRequestDto(
            MODEL,
            questionRequestDto.getQuestion(),
            MAX_TOKEN,
            TEMPERATURE,
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
