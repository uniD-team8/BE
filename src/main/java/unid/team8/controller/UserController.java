package unid.team8.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import unid.team8.service.KeywordService;
import unid.team8.service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/parent/points")
  public Integer getParentPoints(@RequestParam Long id) {
    return userService.getParentPoints(id);
  }
}
