package unid.team8.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unid.team8.entity.Letter;
import unid.team8.entity.User;
import unid.team8.repository.LetterRepository;
import unid.team8.repository.UserRepository;

@Service
public class LetterService {

  @Autowired
  private LetterRepository letterRepository;

  @Autowired
  private UserRepository userRepository;

  public Letter createLetter(String imageUrl, String childSay, Long user_id) {
    Optional<User> result = userRepository.findById(user_id);

    if (result.isEmpty()) {
      return null;
    }
    User user = result.get();
    Letter letter = Letter.builder()
        .imageUrl(imageUrl)
        .childSay(childSay)
        .user(user)
        .build();

    return letterRepository.save(letter); // Save the letter to the database
  }
}
