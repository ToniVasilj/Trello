package io.getarrays.trello.repo;

import io.getarrays.trello.model.BList;
import io.getarrays.trello.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BListRepo extends JpaRepository<BList, Long> {
}
