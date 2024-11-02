package unid.team8.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class AiResponseDto {
    private List<String> missions;
    private List<String> emotions;
}
