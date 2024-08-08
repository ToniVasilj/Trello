package io.getarrays.trello.resource;

import io.getarrays.trello.model.Board;
import io.getarrays.trello.model.Response;
import io.getarrays.trello.service.implementation.BoardServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardResource {
    private final BoardServiceImpl boardService;

    @GetMapping("/list")
    public ResponseEntity<Response> getBoards() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("boards", boardService.list(30)))
                        .message("Boards retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveBoard(@RequestBody @Valid Board board) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", boardService.create(board)))
                        .message("Board created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getBoardById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", boardService.get(id)))
                        .message("Board retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @GetMapping("/getByName/{name}")
    public ResponseEntity<Response> getBoardById(@PathVariable("name") String name) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("board", boardService.getByName(name)))
                        .message("Board retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteBoard(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", boardService.delete(id)))
                        .message("Board deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
