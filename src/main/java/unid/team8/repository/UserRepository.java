package unid.team8.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(Long userId);
  List<User> findByFamilyCode(String familyCode);
}
