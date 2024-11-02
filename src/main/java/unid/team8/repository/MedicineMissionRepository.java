package unid.team8.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.MedicineMission;

public interface MedicineMissionRepository extends JpaRepository<MedicineMission, Long> {
    Optional<MedicineMission> findByMedicineMissionId(Integer medicine_id);
    MedicineMission findByUser_Id(Long userId);
}
