package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import unid.team8.dto.AiResponseDto;
import unid.team8.entity.Keyword;

import unid.team8.entity.ReceivedMission;
import unid.team8.entity.User;

import unid.team8.repository.KeywordRepository;
import unid.team8.repository.ReceivedMissionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AiService {
    private final RestTemplate restTemplate;
    private final ReceivedMissionRepository receivedMissionRepository;
    private final KeywordRepository keywordRepository;
    private final KeywordService keywordService;


    @Value("${ai.server.url}")
    private String aiServerUrl;

    public AiResponseDto sendToAiServer(String dialog) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("dialog", dialog);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(requestBody, headers);

        // AI 서버로 POST 요청 및 AiResponseDto로 응답 받음
        ResponseEntity<AiResponseDto> response = restTemplate.postForEntity(aiServerUrl, entity, AiResponseDto.class); //AI 서버의 응답을 AiResponse 형식으로 매핑하여 받겠다는 의미
        return response.getBody();
    }

    public void saveMissions(List<String> missions, User user){
        for(String mission : missions){
            ReceivedMission receivedMission=ReceivedMission.builder()
                    .missionName(mission)
                    .user(user)
                    .build();
            receivedMissionRepository.save(receivedMission);
        }
    }

    // 반환값 어떻게 받는지 알아내고 수정하기
    public void updateKeyWords(List<String> emotions, User user){
        Keyword keyWordTable=keywordRepository.findByUser_Id(user.getId());
        for(String emotion : emotions){
            keywordService.increaseCount(emotion, user.getId());
        }
        keywordRepository.save(keyWordTable);
    }


}
