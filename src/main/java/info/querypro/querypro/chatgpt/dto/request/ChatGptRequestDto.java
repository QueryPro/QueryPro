package info.querypro.querypro.chatgpt.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptRequestDto {
    private String model;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    private Double temperature;
    private List<Messages> messages;
    @JsonProperty("top_p")
    private Double topP;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class Messages {
        private String role;
        private String content;
    }

}
