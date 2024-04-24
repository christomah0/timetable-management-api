package com.ihm.timetablemanagement.services;

import com.ihm.timetablemanagement.models.Establishment;

import java.util.UUID;

public interface EstablishmentBusinessServiceInterface extends BusinessServiceInterface<Establishment, UUID> {
    // verify existence
    boolean exists(UUID uuid);
}
