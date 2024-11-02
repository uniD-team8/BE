package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unid.team8.dto.AiResponseDto;
import unid.team8.dto.DialogDto;
import unid.team8.entity.User;
import unid.team8.repository.UserRepository;
import unid.team8.service.AiService;

@RestController
@RequiredArgsConstructor
public class ReceivedMissionController {
    private final AiService aiService;
    private final UserRepository userRepository;

    @PostMapping("/dialog")
    public ResponseEntity<Void> postDialog(@RequestBody DialogDto dialogDto){
        User user=userRepository.findById(dialogDto.getUserId()).orElseThrow(()->new IllegalArgumentException("해당 id의 유저가 존재하지 않습니다."));
        AiResponseDto responseDto=aiService.sendToAiServer(dialogDto.getDialog());
        aiService.saveMissions(responseDto.getMissions(), user);
        aiService.updateKeyWords(responseDto.getEmotions(), user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/missions/{userId}")
    public ResponseEntity<MissionResponseDto> getMission(@PathVariable Long userId){


    }
}
