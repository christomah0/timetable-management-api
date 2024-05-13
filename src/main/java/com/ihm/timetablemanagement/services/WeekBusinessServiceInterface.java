package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Week;

import java.util.UUID;

public interface WeekBusinessServiceInterface extends BusinessServiceInterface<Week, UUID>{
    // verify existence
    boolean exists(UUID uuid);

    // Verify by name
    boolean existsByName(String weekday);
}
