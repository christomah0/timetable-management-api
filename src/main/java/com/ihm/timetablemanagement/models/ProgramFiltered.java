package com.ihm.timetablemanagement.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ProgramFiltered {
    private UUID programId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String weekday;
    private String dayPeriod;
    private String moduleName;
    private String courseName;
    private String rankLevel;

    public ProgramFiltered(
            UUID programId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            String weekday,
            String dayPeriod,
            String moduleName,
            String courseName,
            String rankLevel
    ) {
        this.programId = programId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekday = weekday;
        this.dayPeriod = dayPeriod;
        this.moduleName = moduleName;
        this.courseName = courseName;
        this.rankLevel = rankLevel;
    }

    public ProgramFiltered(
            UUID programId,
            LocalDate date,
            LocalTime startTime,
            LocalTime endTime,
            String weekday,
            String moduleName,
            String courseName,
            String rankLevel
    ) {
        this.programId = programId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekday = weekday;
        this.moduleName = moduleName;
        this.courseName = courseName;
        this.rankLevel = rankLevel;
    }
}
