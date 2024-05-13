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
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "course_id")
    private UUID courseId;

    @Column(name = "course_name", nullable = false, length = 254)
    private String courseName;

    @ManyToOne
    @JoinColumn(name = "establishment_id_fk", nullable = false)
    private Establishment establishment;

    @ManyToOne
    @JoinColumn(name = "level_id_fk", nullable = false)
    private Level level;

}
