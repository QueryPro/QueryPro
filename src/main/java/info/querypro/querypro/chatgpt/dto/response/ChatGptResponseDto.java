package info.querypro.querypro.chatgpt.dto.response;

import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.ToString;

/**
 * Some description here.
 *
 * @author : 강명관
 * @since : 1.0
 **/
@Getter
@ToString
public class ChatGptResponseDto {

    private String id;
    private String object;
    private LocalDate created;
    private String model;
    private List<Choice> choices;

}
