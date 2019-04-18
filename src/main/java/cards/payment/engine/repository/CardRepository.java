package cards.payment.engine.repository;

import cards.payment.engine.model.entity.CardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CardEntity,Integer> {

}
