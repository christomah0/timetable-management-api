package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Establishment;
import com.ihm.timetablemanagement.repositories.EstablishmentRepositoryInterface;
import com.ihm.timetablemanagement.services.EstablishmentBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EstablishmentBusinessService implements EstablishmentBusinessServiceInterface {
    private final EstablishmentRepositoryInterface establishmentRepositoryInterface;

    @Autowired
    public EstablishmentBusinessService(EstablishmentRepositoryInterface establishmentRepositoryInterface) {
        this.establishmentRepositoryInterface = establishmentRepositoryInterface;
    }

    @Override
    public List<Establishment> findAll() {
        return establishmentRepositoryInterface.findAll();
    }

    @Override
    public void save(Establishment object) {
        establishmentRepositoryInterface.save(object);
    }

    @Override
    public Establishment findById(UUID object) {
        return establishmentRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        establishmentRepositoryInterface.deleteById(object);
    }

    @Override
    public boolean exists(UUID uuid) {
        return establishmentRepositoryInterface.existsById(uuid);
    }
}
