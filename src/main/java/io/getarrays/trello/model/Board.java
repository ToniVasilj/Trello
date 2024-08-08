package io.getarrays.trello.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.AUTO;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "boards")
public class Board {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "boardId")
    private Long id;

    @Column(name = "boardName", unique = true)
    @NotEmpty(message = "Board name cannot be empty")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "board_id")
    private List<BList> bLists = new ArrayList<>();
}
