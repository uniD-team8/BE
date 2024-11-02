package unid.team8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.service.KeywordService;

@RestController
public class KeywordController {

  @Autowired
  private KeywordService keywordService;

  @GetMapping("/keywords")
  public List<String> getTop2Keywords(@RequestParam Long id) {
    return keywordService.getTop2Keywords(id);
  }
}
