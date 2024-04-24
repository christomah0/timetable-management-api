package com.ihm.timetablemanagement.services.implementations;

import com.ihm.timetablemanagement.models.Level;
import com.ihm.timetablemanagement.repositories.LevelRepositoryInterface;
import com.ihm.timetablemanagement.services.LevelBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LevelBusinessService implements LevelBusinessServiceInterface {
    private final LevelRepositoryInterface levelRepositoryInterface;

    @Autowired
    public LevelBusinessService(LevelRepositoryInterface levelRepositoryInterface) {
        this.levelRepositoryInterface = levelRepositoryInterface;
    }

    @Override
    public boolean exists(UUID uuid) {
        return levelRepositoryInterface.existsById(uuid);
    }

    @Override
    public List<Level> findAll() {
        return levelRepositoryInterface.findAll();
    }

    @Override
    public void save(Level object) {
        levelRepositoryInterface.save(object);
    }

    @Override
    public Level findById(UUID object) {
        return levelRepositoryInterface.findById(object).orElse(null);
    }

    @Override
    public void deleteById(UUID object) {
        levelRepositoryInterface.deleteById(object);
    }
}
