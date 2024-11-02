package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
