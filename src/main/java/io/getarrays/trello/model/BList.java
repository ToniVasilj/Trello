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
@Table(name = "bLists")
public class BList {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "bListId", unique = true)
    private Long id;

    @Column(name = "bListName")
    @NotEmpty(message = "BList name cannot be empty")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "bList_id")
    private List<Card> cards = new ArrayList<>();
}
