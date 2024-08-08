package io.getarrays.trello.service.implementation;

import io.getarrays.trello.model.Card;
import io.getarrays.trello.repo.BoardRepo;
import io.getarrays.trello.repo.CardRepo;
import io.getarrays.trello.service.CardService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import static java.lang.Boolean.TRUE;


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class CardServiceImpl implements CardService {
    @Autowired
    private final BoardRepo boardRepo;
    @Autowired
    private final CardRepo cardRepo;

    @Override
    public Card create(Long boardId, Long bListId, Card card) {
        log.info("Saving new card: {} to bList: {} within board {}", card.getText(), bListId, boardId);
        boardRepo.findById(boardId).get()
                .getBLists().stream().filter(bList ->
                        bList.getId().equals(bListId)).findFirst().get()
                .getCards().add(card);
        return cardRepo.save(card);
    }

    @Override
    public Collection<Card> list(Long boardId, Long bListId) {
        log.info("Fetching all cards from bList: {} within board: {}", bListId, boardId);
        return boardRepo.findById(boardId).get()
                .getBLists().stream().filter(bList ->
                        bList.getId().equals(bListId)).findFirst()
                .get().getCards().stream().toList();
    }

    @Override
    public Card get(Long id) {
        log.info("Get card by Id: {}", id);
        return cardRepo.findById(id).get();
    }

    @Override
    public Card updateText(Card card) {
        log.info("Updating card Text of card: {}", card.getId());
        Card existingCard = cardRepo.findById(card.getId())
                .orElseThrow(()->new EntityNotFoundException("Card not found with id " + card.getId()));

        existingCard.setText(card.getText());
        return cardRepo.save(existingCard);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting card with id: {}", id);
        cardRepo.deleteById(id);
        return TRUE;
    }
}
