package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.ReceivedMission;

public interface ReceivedMissionRepository extends JpaRepository<ReceivedMission, Long> {
}