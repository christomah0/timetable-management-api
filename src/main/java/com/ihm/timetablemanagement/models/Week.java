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
@Table(name = "week")
public class Week {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "week_id")
    private UUID weekId;

    @Column(name = "day_name", nullable = false, length = 11)
    private String dayName;
}
