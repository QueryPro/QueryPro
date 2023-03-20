package info.querypro.querypro.chatgpt.controller;

import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/

@RestController
@RequiredArgsConstructor
public class ChatGptTestController {

    private final ChatGptService chatGptService;

    @GetMapping("/test")
    public ChatGptResponseDto getAnswer() {
        return chatGptService.questionChatGpt(new QuestionRequestDto("안녕??"));
    }

}
