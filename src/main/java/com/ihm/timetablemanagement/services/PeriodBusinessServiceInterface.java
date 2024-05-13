package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Period;

import java.util.UUID;

public interface PeriodBusinessServiceInterface extends BusinessServiceInterface<Period, UUID> {
    // Verify the existence of any period by day period
    boolean existsByDayPeriod(String dayPeriod);

    // Verify the existence of any period by id
    boolean existsById(UUID uuid);
}
