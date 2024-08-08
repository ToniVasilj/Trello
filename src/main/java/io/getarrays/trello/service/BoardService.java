package io.getarrays.trello.service;

import io.getarrays.trello.model.Board;

import java.util.Collection;

public interface BoardService {
    Board create(Board board);
    Collection<Board> list(int limit);
    Board get(Long id);
    Board getByName(String name);
    Board update(Board board);
    Boolean delete(Long id);
}
