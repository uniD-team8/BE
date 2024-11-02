package unid.team8.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.Letter;

public interface LetterRepository extends JpaRepository<Letter, Long> {
  Optional<Letter> findByUserId(Long userId);
}
