package unid.team8.service;

import com.fasterxml.jackson.databind.ObjectMapper;
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

  @Autowired
  private ObjectMapper objectMapper;

  public List<String> getTop2Keywords(Long id) {
    Optional<Keyword> keywordOpt = keywordRepository.findById(id);
    if (keywordOpt.isEmpty()) {
      return List.of(); // Return an empty list if no keyword is found
    }

    Keyword keyword = keywordOpt.get();

    // Convert Keyword entity to a Map of attribute names and values
    Map<String, Long> attributes = objectMapper.convertValue(keyword, Map.class);

    // Sort attributes by value in descending order and get the top 2 attribute names
    return attributes.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .limit(2)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
  }
}
