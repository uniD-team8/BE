package unid.team8.service;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unid.team8.entity.Keyword;
import unid.team8.entity.User;
import unid.team8.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

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
}
