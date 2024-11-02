package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AiService {
    //private final RestTemplate restTemplate;
    //private final ReceivedMissionRepository receivedMissionRepository;

    //public sendToAiServer
}
