package unid.team8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.entity.Letter;
import unid.team8.service.KeywordService;
import unid.team8.service.LetterService;
import unid.team8.service.UserService;

@RestController
@CrossOrigin(origins="*")
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
  public void createChildSay(@RequestParam Long user_id, @RequestParam String content, @RequestParam String imageUrl) {
    letterService.createLetter(imageUrl, content, user_id);
  }
}
