package io.getarrays.trello.repo;

import io.getarrays.trello.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long> {
    Board findByName(String name);
}
