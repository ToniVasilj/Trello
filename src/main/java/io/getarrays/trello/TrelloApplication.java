package io.getarrays.trello;

import io.getarrays.trello.model.BList;
import io.getarrays.trello.model.Board;
import io.getarrays.trello.repo.BoardRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrelloApplication.class, args);
	}
	@Bean
	CommandLineRunner run(BoardRepo boardRepo) {
		return args -> {
			Board board1 = new Board();
			board1.setName("B1");
			BList bList1 = new BList(null, "BList1");
			board1.getBLists().add(bList1);
			BList bList2 = new BList(null, "BList2");
			board1.getBLists().add(bList2);
			boardRepo.save(board1);
		};
	}
}
