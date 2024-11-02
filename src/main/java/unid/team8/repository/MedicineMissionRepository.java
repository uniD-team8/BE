package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.MedicineMission;

public interface MedicineMissionRepository extends JpaRepository<MedicineMission, Long> {
    MedicineMission findByUser_Id(Long userId);
}
