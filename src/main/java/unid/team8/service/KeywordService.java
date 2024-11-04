package unid.team8.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unid.team8.entity.Keyword;
import unid.team8.repository.KeywordRepository;

@Service
@RequiredArgsConstructor
public class KeywordService {
    private final KeywordRepository keyWordRepository;

    public List<Keyword> getAllKeywords() {
        return keyWordRepository.findAll();
    }


    public List<String> getTop2Keywords(Long user_id) {
        Optional<Keyword> keywordOpt = keyWordRepository.findByUserId(user_id);


    if (keywordOpt.isEmpty()) {
      return List.of(); // Return an empty list if no keyword is found
    }

    Keyword keyword = keywordOpt.get();

    // Manually map attributes from the Keyword entity
    Map<String, Long> attributes = new HashMap<>();
    attributes.put("happy", keyword.getHappy());
    attributes.put("satisfied", keyword.getSatisfied());
    attributes.put("positive_feeling", keyword.getPositiveFeeling());
    attributes.put("peaceful", keyword.getPeaceful());
    attributes.put("stable", keyword.getStable());
    attributes.put("mindful", keyword.getMindful());
    attributes.put("depressed", keyword.getDepressed());
    attributes.put("lost", keyword.getLost());
    attributes.put("overwhelmed", keyword.getOverwhelmed());
    attributes.put("angry", keyword.getAngry());
    attributes.put("annoyed", keyword.getAnnoyed());
    attributes.put("dissatisfied", keyword.getDissatisfied());
    attributes.put("worried", keyword.getWorried());
    attributes.put("tense", keyword.getTense());
    attributes.put("stress", keyword.getStress());
    attributes.put("user_id", keyword.getId());
    // Add other attributes as needed

        // Sort attributes by value in descending order and get the top 2 attribute names
        return attributes.entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(2)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

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
