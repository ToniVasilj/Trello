package io.getarrays.trello.resource;

import io.getarrays.trello.model.Card;
import io.getarrays.trello.model.Response;
import io.getarrays.trello.service.implementation.CardServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class CardResource {
    private final CardServiceImpl cardService;

    @PostMapping("/board/{boardId}/blist/{bListId}/save")
    public ResponseEntity<Response> saveBListToBoard(@PathVariable("boardId") Long boardId, @PathVariable("bListId") Long bListId, @RequestBody @Valid Card card) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("bList", cardService.create(boardId, bListId, card)))
                        .message("Card created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/board/{boardId}/list/{bListId}/cards")
    public ResponseEntity<Response> getBListsByBoardId(@PathVariable("boardId") Long boardId, @PathVariable("bListId") Long bListId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("bLists", cardService.list(boardId, bListId)))
                        .message("Cards retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/card/get/{cardId}")
    public ResponseEntity<Response> getBoardById(@PathVariable("cardId") Long cardId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", cardService.get(cardId)))
                        .message("Card retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/card/updateText")
    public ResponseEntity<Response> updateCardText(@RequestBody @Valid Card card) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", cardService.updateText(card)))
                        .message("Card text updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/card/delete/{cardId}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("cardId") Long cardId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", cardService.delete(cardId)))
                        .message("Card deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
