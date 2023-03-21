package info.querypro.querypro.chatgpt.util;

/**
 * ChatGPT 통신에 필요한 상수를 정의해놓은 클래스 입니다.
 *
 * @author : 강명관
 * @since : 1.0
 **/
public class ChatGptConstant {

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String API_KEY = "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";
    public static final String MODEL = "gpt-3.5-turbo-0301";
    public static final String URL = "https://api.openai.com/v1/chat/completions";
    public static final Double TEMPERATURE = 0.2;
    public static final Double TOP_P = 0.1;
    public static final Integer MAX_TOKEN = 2048;

}
