package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import unid.team8.dto.AiResponseDto;
import unid.team8.dto.MissionResponseDto;
import unid.team8.entity.MedicineMission;
import unid.team8.entity.ReceivedMission;
import unid.team8.repository.MedicineMissionRepository;
import unid.team8.repository.ReceivedMissionRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReceivedMissionService {
    private final ReceivedMissionRepository receivedMissionRepository;
    private final MedicineMissionRepository medicineMissionRepository;


    public MissionResponseDto getMissions(Long userId){
        List<ReceivedMission> userMission=receivedMissionRepository.findByUser_Id(userId);
        MedicineMission medicineMission=medicineMissionRepository.findByUser_Id(userId);

        LocalDate nowDate=LocalDate.now();
        MissionResponseDto missionResponseDto=new MissionResponseDto();

        for(ReceivedMission mission:userMission){
            if(mission.getCreated_at()==nowDate){
                missionResponseDto.getMissions().add(mission.getMissionName());
            }
        }

        if(medicineMission.getRecentTime()==nowDate){
            missionResponseDto.setMedicine(true);
        }
        else
            missionResponseDto.setMedicine(false);

        return missionResponseDto;

    }
}
