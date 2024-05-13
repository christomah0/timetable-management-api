package com.ihm.timetablemanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "period")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "period_id")
    private UUID periodId;

    @Column(name = "day_period", nullable = false, length = 3, unique = true)
    private String dayPeriod;

    public Period(UUID periodId) {
        this.periodId = periodId;
    }

    public Period(String dayPeriod) {
        this.dayPeriod = dayPeriod;
    }

    public Period(UUID periodId, String dayPeriod) {
        this.periodId = periodId;
        this.dayPeriod = dayPeriod;
    }
}
