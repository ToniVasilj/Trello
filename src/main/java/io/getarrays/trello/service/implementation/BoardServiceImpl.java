package io.getarrays.trello.service.implementation;

import io.getarrays.trello.model.Board;
import io.getarrays.trello.repo.BoardRepo;
import io.getarrays.trello.service.BoardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

import static java.lang.Boolean.*;
import static org.springframework.data.domain.PageRequest.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {
    private final BoardRepo boardRepo;

    @Override
    public Board create(Board board) {
        log.info("Saving new board: {}", board.getName());
        return boardRepo.save(board);
    }

    @Override
    public Collection<Board> list(int limit) {
        log.info("Fetching all boards");
        return boardRepo.findAll(of(0,limit)).toList();
    }

    @Override
    public Board get(Long id) {
        log.info("Fetching board by id: {}", id);
        return boardRepo.findById(id).get();
    }

    @Override
    public Board getByName(String name) {
        log.info("Fetching board by name: {}", name);
        return boardRepo.findByName(name);
    }

    @Override
    public Board update(Board board) {
        log.info("Updating board: {}", board.getName());
        return boardRepo.save(board);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting board by id: {}", id);
        boardRepo.deleteById(id);
        return TRUE;
    }
}
