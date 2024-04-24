package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Level;

import java.util.UUID;

public interface LevelBusinessServiceInterface extends BusinessServiceInterface<Level, UUID> {
    // verify existence
    boolean exists(UUID uuid);
}
