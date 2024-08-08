package io.getarrays.trello.service.implementation;

import io.getarrays.trello.model.BList;
import io.getarrays.trello.model.Board;
import io.getarrays.trello.repo.BListRepo;
import io.getarrays.trello.repo.BoardRepo;
import io.getarrays.trello.service.BListService;
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
public class BListServiceImpl implements BListService {
    @Autowired
    private final BoardRepo boardRepo;
    @Autowired
    private final BListRepo bListRepo;

    @Override
    public BList create(Long boardId, BList bList) {
        log.info("Saving new bList: {} to boardId: {}", bList.getName(), boardId);
        boardRepo.findById(boardId).get().getBLists().add(bList);
        return bListRepo.save(bList);
    }
    @Override
    public Collection<BList> list(Long boardId, int limit) {
        log.info("Fetching all bLists");
        return boardRepo.findById(boardId).get().getBLists().stream().toList();
    }

    @Override
    public BList get(Long boardId, Long id) {
        log.info("Fetching bList by id: {} from boardId: {}", id, boardId);
        return boardRepo.findById(boardId).get().getBLists().stream().filter(bList -> bList.getId().equals(id)).findFirst().get();
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting bList by id: {}", id);
        bListRepo.deleteById(id);
        return TRUE;
    }
}
