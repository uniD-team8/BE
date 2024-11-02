package unid.team8.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MissionResponseDto {
    private List<String> missions;
    //private List<String> keyword;
    private boolean isMedicine;
    private String summary;
}
