package io.getarrays.trello.service;

import io.getarrays.trello.model.Card;

import java.util.Collection;

public interface CardService {
    Card create(Long boardId, Long bListId, Card card);
    Collection<Card> list(Long boardId, Long bListId);
    Card get(Long id);
    Card updateText(Card card);
    Boolean delete(Long id);
}
