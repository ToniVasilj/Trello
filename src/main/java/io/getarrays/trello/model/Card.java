package io.getarrays.trello.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "cardId")
    private Long id;

    @Column(name = "cardText")
    @NotEmpty(message = "cardText cannot be empty")
    private String text;
}
