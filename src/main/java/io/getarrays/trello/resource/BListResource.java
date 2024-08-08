package io.getarrays.trello.resource;

import io.getarrays.trello.model.BList;
import io.getarrays.trello.model.Board;
import io.getarrays.trello.model.Response;
import io.getarrays.trello.service.implementation.BListServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/board/{boardId}")
@RequiredArgsConstructor
public class BListResource {
    private final BListServiceImpl bListService;

    @GetMapping("/list")
    public ResponseEntity<Response> getBListsByBoardId(@PathVariable("boardId") Long boardId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("bLists", bListService.list(boardId, 30)))
                        .message("BLists retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveBListToBoard(@PathVariable("boardId") Long boardId, @RequestBody @Valid BList bList) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("bList", bListService.create(boardId, bList)))
                        .message("Board created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{bListId}")
    public ResponseEntity<Response> getBoardById(@PathVariable("boardId") Long boardId, @PathVariable("bListId") Long bListId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", bListService.get(boardId, bListId)))
                        .message("BList retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{bListId}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("bListId") Long bListId) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", bListService.delete(bListId)))
                        .message("bList deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
