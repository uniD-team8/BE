package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unid.team8.dto.AiResponseDto;
import unid.team8.dto.DialogDto;
import unid.team8.dto.MissionRequestDto;
import unid.team8.dto.MissionResponseDto;
import unid.team8.entity.User;
import unid.team8.repository.UserRepository;
import unid.team8.service.AiService;
import unid.team8.service.ReceivedMissionService;

@RestController
@RequiredArgsConstructor
public class ReceivedMissionController {
    private final AiService aiService;
    private final UserRepository userRepository;
    private final ReceivedMissionService receivedMissionService;

    @PostMapping("/dialog")
    public ResponseEntity<Void> postDialog(@RequestBody DialogDto dialogDto){
        User user=userRepository.findById(dialogDto.getUserId()).orElseThrow(()->new IllegalArgumentException("해당 id의 유저가 존재하지 않습니다."));
        AiResponseDto responseDto=aiService.sendToAiServer(dialogDto.getDialog());
        aiService.saveMissions(responseDto.getData().getMissions(), user);
        aiService.updateKeyWords(responseDto.getData().getEmotions(), user);
        aiService.saveSummary(responseDto.getData().getSummary(), user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/missions/{userId}")
    public ResponseEntity<MissionResponseDto> getMission(@PathVariable Long userId){
        MissionResponseDto missions=receivedMissionService.getMissions(userId);
        return ResponseEntity.ok().body(missions);
    }

    @PutMapping("/missions/status")
    public ResponseEntity<Void> updateMissionStatus(@RequestBody MissionRequestDto missionRequestDto){
        receivedMissionService.updateStatus(missionRequestDto);
        return ResponseEntity.ok().build();
    }
}
