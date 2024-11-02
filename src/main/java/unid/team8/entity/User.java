package unid.team8.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "User")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String photo;

    private String name;

    private Integer point;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "is_Parent", nullable = false)
    private Boolean isParent;

    @Column(name = "family_code", nullable = false)
    private String familyCode;

    @Column(name = "gift_id", nullable = false)
    private Long giftId;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private MedicineMission medicineMission;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Keyword keyword; // Keyword와 1:1 관계
<<<<<<< Updated upstream


    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Letter letter; // Keyword와 1:1 관계


=======
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Letter letter; // Keyword와 1:1 관계
>>>>>>> Stashed changes
}
