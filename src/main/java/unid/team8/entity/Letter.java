package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Letter")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Letter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "letter_id")
    private Integer letterId;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "child_say", nullable = false)
    private String childSay;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
