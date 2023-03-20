package info.querypro.querypro.chatgpt.service;

import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface ChatGptService {

    ChatGptResponseDto questionChatGpt(QuestionRequestDto questionRequestDto);
    
}
