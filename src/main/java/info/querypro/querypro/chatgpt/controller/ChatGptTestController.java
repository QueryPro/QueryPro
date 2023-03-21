package info.querypro.querypro.chatgpt.controller;

import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.configurationprocessor.json.JSONException;
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
    public StringBuilder getAnswer() throws JSONException {

        return chatGptService.questionChatGpt(new QuestionRequestDto("너는 이제부터 백엔드 개발자를 채용하는 면접관이야.\n" +
                "면접에 맞는 질문 10가지를 답변과 함께 Markdown toggle 형식으로 줘"));
    }

}
