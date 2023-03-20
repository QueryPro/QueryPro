package info.querypro.querypro.chatgpt.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Choice {

    private String text;
    private Integer index;
    @JsonProperty("finish_reason")
    private String finishReason;

}
