package unid.team8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unid.team8.dto.ChildSayDto;
import unid.team8.entity.Letter;
import unid.team8.service.KeywordService;
import unid.team8.service.LetterService;
import unid.team8.service.UserService;

@RestController
@CrossOrigin(origins="*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS, RequestMethod.HEAD})
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private LetterService letterService;

  @GetMapping("/parent/points")
  public Integer getParentPoints(@RequestParam Long id) {
    return userService.getParentPoints(id);
  }

  @GetMapping("/child/say")
  public String getChildSay(@RequestParam Long id) {
    return userService.getChildSay(id);
  }

  @PostMapping("/child/say")
  public void createChildSay(@RequestBody ChildSayDto childSayDto) {
    letterService.createLetter(childSayDto);
  }
}
