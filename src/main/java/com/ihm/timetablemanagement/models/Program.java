package com.ihm.timetablemanagement.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
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

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "start_time", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;

    @Column(name = "end_time", nullable = false)
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "course_id_fk", nullable = false)
    private Course course;

    @ManyToOne
    @JoinColumn(name = "week_id_fk", nullable = false)
    private Week week;

    @ManyToOne
    @JoinColumn(name = "period_id_fk")
    private Period period;
}
