package unid.team8.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AiResponseDto {
    private String status;
    private DataDto data; // data 객체를 포함

    @Getter
    @Setter
    public static class DataDto {
        private List<String> emotions;
        private List<String> missions;
        private String summary;
    }
}
