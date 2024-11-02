package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Keyword")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class Keyword {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "happy", nullable = false)
    private Long happy; // 기쁨

    @Column(name = "satisfied", nullable = false)
    private Long satisfied; // 만족

    @Column(name = "positive_feeling", nullable = false)
    private Long positiveFeeling; // 긍정적인 느낌

    @Column(name = "peaceful", nullable = false)
    private Long peaceful; // 평화

    @Column(name = "stable", nullable = false)
    private Long stable; // 안정감

    @Column(name = "mindful", nullable = false)
    private Long mindful; // 마음의 평화

    @Column(name = "depressed", nullable = false)
    private Long depressed; // 우울

    @Column(name = "lost", nullable = false)
    private Long lost; // 상실감

    @Column(name = "overwhelmed", nullable = false)
    private Long overwhelmed; // 좌절

    @Column(name = "angry", nullable = false)
    private Long angry; // 화남

    @Column(name = "annoyed", nullable = false)
    private Long annoyed; // 짜증

    @Column(name = "dissatisfied", nullable = false)
    private Long dissatisfied; // 불만

    @Column(name = "worried", nullable = false)
    private Long worried; // 걱정

    @Column(name = "tense", nullable = false)
    private Long tense; // 긴장

    @Column(name = "stress", nullable = false)
    private Long stress; // 스트레스

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
