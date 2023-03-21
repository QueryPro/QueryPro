package info.querypro.querypro.chatgpt.service;

import info.querypro.querypro.chatgpt.dto.request.QuestionRequestDto;
import info.querypro.querypro.chatgpt.dto.response.ChatGptResponseDto;
import org.springframework.boot.configurationprocessor.json.JSONException;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public interface ChatGptService {

    StringBuilder questionChatGpt(QuestionRequestDto questionRequestDto) throws JSONException;
    
}
