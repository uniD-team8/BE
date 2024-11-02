package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.ReceivedMission;

import java.util.List;

public interface ReceivedMissionRepository extends JpaRepository<ReceivedMission, Long> {
    List<ReceivedMission> findByUser_Id(Long userId);

    ReceivedMission findByMissionName(String missionName);
}
