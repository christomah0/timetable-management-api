package com.ihm.timetablemanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "mention")
public class Mention {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "mention_id")
    private UUID mentionId;

    @Column(name = "name", nullable = false, length = 254)
    private String name;

    @ManyToOne
    @JoinColumn(name = "establishment_id_fk", nullable = false)
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "level_id_fk", nullable = false)
    private Level level;
}
