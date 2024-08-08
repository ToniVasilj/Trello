package io.getarrays.trello.service;

import io.getarrays.trello.model.BList;

import java.util.Collection;

public interface BListService {
    BList create(Long boardId, BList bList);
    Collection<BList> list(Long boardId);
    BList get(Long id);
    Boolean delete(Long id);
}
