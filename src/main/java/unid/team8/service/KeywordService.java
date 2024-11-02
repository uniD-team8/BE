package unid.team8.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unid.team8.entity.Keyword;
import unid.team8.repository.KeywordRepository;

@Service
public class KeywordService {

  @Autowired
  private KeywordRepository keywordRepository;

  public List<Keyword> getAllKeywords() {
    return keywordRepository.findAll();
  }

  public List<String> getTop2Keywords(Long user_id) {
    Optional<Keyword> keywordOpt = keywordRepository.findByUserId(user_id);

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
}
