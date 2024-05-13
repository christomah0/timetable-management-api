package com.ihm.timetablemanagement.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "week")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "week_id")
    private UUID weekId;

    @Column(name = "weekday", nullable = false, length = 11, unique = true)
    private String weekday;

    public Week(UUID weekId) {
        this.weekId = weekId;
    }

    public Week(String weekday) {
        this.weekday = weekday;
    }

    public Week(UUID weekId, String weekday) {
        this.weekId = weekId;
        this.weekday = weekday;
    }
}
