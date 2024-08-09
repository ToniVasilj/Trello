package io.getarrays.trello.repo;

import io.getarrays.trello.model.Board;
import io.getarrays.trello.model.projection.BoardProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BoardRepo extends JpaRepository<Board, Long> {
    Board findByName(String name);
    Collection<BoardProjection> findAllProjectedBy();
}
