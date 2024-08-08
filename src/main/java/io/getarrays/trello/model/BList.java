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
@Table(name = "bLists")
public class BList {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "bListId")
    private Long id;

    @Column(name = "bListName", unique = true)
    @NotEmpty(message = "BList name cannot be empty")
    private String name;
}
