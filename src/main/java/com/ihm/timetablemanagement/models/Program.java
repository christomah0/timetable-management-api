package com.ihm.timetablemanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "program_id")
    private UUID programId;

    @Column(name = "module_name", nullable = false, length = 127)
    private String moduleName;

    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_datetime", nullable = false)
    private LocalDateTime endDateTime;

    @ManyToOne
    @JoinColumn(name = "level_id_fk", nullable = false)
    private Level level;

    @ManyToOne
    @JoinColumn(name = "week_id_fk", nullable = false)
    private Week week;

    @Column(name = "day_period")
    private String dayPeriod;
}
