package unid.team8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GiftResponseDto {
    private Long id;
    private String name;
    private Integer points;
    private String photo;
}
