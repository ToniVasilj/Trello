package io.getarrays.trello.service;

import io.getarrays.trello.model.BList;

import java.util.Collection;

public interface BListService {
    BList create(Long boardId, BList bList);
    Collection<BList> list(Long boardId, int limit);
    BList get(Long boardId, Long id);
    Boolean delete(Long id);
}
