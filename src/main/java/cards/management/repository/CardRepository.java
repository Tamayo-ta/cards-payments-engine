package cards.management.repository;

import cards.management.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Integer> {

    CardEntity findByOwnerIdAndNumber(Integer ownerId, Long Number);
}
