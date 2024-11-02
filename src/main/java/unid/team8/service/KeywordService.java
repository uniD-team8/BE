package unid.team8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.entity.Keyword;
import unid.team8.repository.KeywordRepository;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keyWordRepository;

    public void increaseCount(String emotion, Long userId){
        Keyword keyword=keyWordRepository.findByUser_Id(userId);

        switch (emotion) {
            case "happy":
                keyword.setHappy(keyword.getHappy()+1);
                break;
            case "satisfied":
                keyword.setSatisfied(keyword.getSatisfied()+1);
                break;
            case "positiveFeeling":
                keyword.setPositiveFeeling(keyword.getPositiveFeeling()+1);
                break;
            case "peaceful":
                keyword.setPeaceful(keyword.getPeaceful()+1);
                break;
            case "stable":
                keyword.setStable(keyword.getStable()+1);
                break;
            case "mindful":
                keyword.setMindful(keyword.getMindful()+1);
                break;
            case "depressed":
                keyword.setDepressed(keyword.getDepressed()+1);
                break;
            case "lost":
                keyword.setLost(keyword.getLost()+1);
                break;
            case "overwhelmed":
                keyword.setOverwhelmed(keyword.getOverwhelmed()+1);
                break;
            case "angry":
                keyword.setAngry(keyword.getAngry()+1);
                break;
            case "annoyed":
                keyword.setAnnoyed(keyword.getAnnoyed()+1);
                break;
            case "dissatisfied":
                keyword.setDissatisfied(keyword.getDissatisfied()+1);
                break;
            case "worried":
                keyword.setWorried(keyword.getWorried()+1);
                break;
            case "tense":
                keyword.setTense(keyword.getTense()+1);
                break;
            case "stress":
                keyword.setStress(keyword.getStress()+1);
                break;
            default:
                throw new IllegalArgumentException("Unknown emotion: " + emotion);
        }
    }
}
