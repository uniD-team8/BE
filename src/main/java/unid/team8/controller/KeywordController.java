package unid.team8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unid.team8.service.KeywordService;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS, RequestMethod.HEAD})
public class KeywordController {

  @Autowired
  private KeywordService keywordService;

  @GetMapping("/keywords")
  public List<String> getTop2Keywords(@RequestParam Long id) {
    return keywordService.getTop2Keywords(id);
  }
}