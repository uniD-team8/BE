package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA의 엔티티는 기본 생성자가 반드시 필요함
@Builder
@AllArgsConstructor
public class ReceivedMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="received_mission_id")
    private Long id;

    private String missionName;

    @Builder.Default
    private boolean status=false;

    @CreationTimestamp
    private LocalDate created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
}
