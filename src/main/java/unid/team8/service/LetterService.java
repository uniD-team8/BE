package unid.team8.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unid.team8.dto.ChildSayDto;
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

  public Letter createLetter(ChildSayDto childSayDto) {
    Optional<User> result = userRepository.findById(childSayDto.getUserId());

    if (result.isEmpty()) {
      return null;
    }
    User user = result.get();
    Letter letter = Letter.builder()
        .imageUrl(childSayDto.getImageUrl())
        .childSay(childSayDto.getContent())
        .user(user)
        .build();

    return letterRepository.save(letter); // Save the letter to the database
  }
}
