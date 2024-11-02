package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Medicine_Mission")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
public class MedicineMission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_mission_id")
    private Integer medicineMissionId;

    @Column(name = "medicine_name")
    private String medicine_name;

    @Column(name = "recent_time", nullable = false)
    private java.sql.Timestamp recentTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}