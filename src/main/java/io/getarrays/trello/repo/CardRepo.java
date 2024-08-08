package io.getarrays.trello.repo;

import io.getarrays.trello.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepo extends JpaRepository<Card, Long> {
}
