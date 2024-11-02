package unid.team8.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
  Optional<Keyword> findByUserId(Long userId);
}
