package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.Gift;

public interface GiftRepository extends JpaRepository<Gift, Integer> {
    // 기본적인 CRUD 메서드를 JpaRepository가 제공함
}
