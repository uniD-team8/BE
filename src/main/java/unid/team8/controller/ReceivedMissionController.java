package unid.team8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.dto.AiResponseDto;
import unid.team8.dto.DialogDto;
import unid.team8.service.AiService;

@RestController
@RequiredArgsConstructor
public class ReceivedMissionController {
    private final AiService aiService;
    /*
    @PostMapping("/dialog")
    public ResponseEntity<Void> postDialog(@RequestBody DialogDto dialogDto){
        AiResponseDto responseDto=aiService.sendToAiServer(dialogDto.getDialog());
        aiService.saveMissions(responseDto.getMissions());
        aiService.updateKeyWord(responseDto.getKeyword());
        return ResponseEntity.ok().build();

    }

     */
}
