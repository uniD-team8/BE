package unid.team8.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    @JsonProperty("user_id")
    private Long userId;
}
