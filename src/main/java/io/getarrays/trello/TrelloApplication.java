package io.getarrays.trello;

import io.getarrays.trello.model.BList;
import io.getarrays.trello.model.Board;
import io.getarrays.trello.model.Card;
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

			BList bList1 = new BList();
			bList1.setName("BList1");
			BList bList2 = new BList();
			bList2.setName("BList2");

			Card card1 = new Card();
			card1.setText("Card1 txt");
			Card card2 = new Card();
			card2.setText("Card2 txt");

			bList1.getCards().add(card1);
			bList1.getCards().add(card2);

			board1.getBLists().add(bList1);
			board1.getBLists().add(bList2);
			boardRepo.save(board1);
		};
	}
}
