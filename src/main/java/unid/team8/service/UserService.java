package unid.team8.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.entity.Letter;
import unid.team8.entity.User;
import unid.team8.repository.LetterRepository;
import unid.team8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final LetterRepository letterRepository;

  public Integer getParentPoints(Long userId) {
    Optional<User> result = userRepository.findById(userId);
    if (result.isEmpty()) {
      return -1; // Return an empty list if no keyword is found
    }

    User user = result.get();
    List<User> family = userRepository.findByFamilyCode(user.getFamilyCode());

    for (User u : family) {
      if (u.getIsParent()) {
        return u.getPoint();
      }
    }

    return -1;
  }

  public String getChildSay(Long userId) {
    Optional<User> result = userRepository.findById(userId);
    if (result.isEmpty()) {
      return "no user";
    }

    User user = result.get();
    List<User> family = userRepository.findByFamilyCode(user.getFamilyCode());

    Long childId = 0L;
    for (User u : family) {
      if (!u.getIsParent()) {
        childId = u.getId();
      }
    }

    Optional<Letter> letter = letterRepository.findByUserId(childId);
    if (letter.isEmpty()) {
      return "no content";
    }

    return letter.get().getChildSay();
  }
}
