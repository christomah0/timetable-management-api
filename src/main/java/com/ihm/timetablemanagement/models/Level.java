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
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "level_id")
    private UUID levelId;

    @Column(name = "rankLevel", nullable = false, length = 3, unique = true)
    private String rankLevel;
}
