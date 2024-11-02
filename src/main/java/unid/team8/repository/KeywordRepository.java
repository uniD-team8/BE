package unid.team8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import unid.team8.entity.Keyword;

public interface KeywordRepository extends JpaRepository<Keyword, Long> {
    Keyword findByUser_Id(Long userId);
}
