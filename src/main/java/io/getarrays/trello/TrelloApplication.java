package io.getarrays.trello;

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
			boardRepo.save(new Board(null, "Board1"));
			boardRepo.save(new Board(null, "Board2"));
			boardRepo.save(new Board(null, "Board3"));
		};
	}
}
