package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Gift")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer points;

    @Column(nullable = false)
    private String photo;
}
