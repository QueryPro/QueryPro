package info.querypro.querypro.chatgpt.controller;

import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.service.ChatGptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatGptTestController {

    private final ChatGptService chatGptService;

    private final Integer QUESTION_COUNT = 10;

    @GetMapping("/test")
    public StringBuilder getAnswer() throws JSONException {

//        String questionQuery = String.format("너는 이제부터 자바 스프링 백엔드 개발자를 채용하는 면접관이야. " +
//            "면접에 맞는 질문 %d 가지를 답변과 함께 줘 " +
//            "응답 형식은 1. 질문내용 개행 후 answer: 답변내용", QUESTION_COUNT);

        String questionQuery = "너는 이제부터 java, spring 백엔드 개발자를 채용하는 면접관이야. 면접에 맞는 질문을 하나만 해줘" +
            "응답 형식은 Question: 질문내용 개행 후 Answer: 답변내용";

        log.warn("questionQuery {}", questionQuery);

        return chatGptService.questionChatGpt(
            new QuestionRequestDto(questionQuery));
    }

}
