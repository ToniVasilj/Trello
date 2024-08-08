package io.getarrays.trello.service.implementation;

import io.getarrays.trello.model.Board;
import io.getarrays.trello.repo.BoardRepo;
import io.getarrays.trello.service.BoardService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.*;
import static org.springframework.data.domain.PageRequest.*;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class BoardServiceImpl implements BoardService {
    @Autowired
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
    public Board updateName(Board board) {
        log.info("Updating board name: {}", board.getName());
        Board existingBoard = boardRepo.findById(board.getId())
                .orElseThrow(()->new EntityNotFoundException("Board not found with id " + board.getId()));

        existingBoard.setName(board.getName());
        return boardRepo.save(existingBoard);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting board by id: {}", id);
        boardRepo.deleteById(id);
        return TRUE;
    }
}
