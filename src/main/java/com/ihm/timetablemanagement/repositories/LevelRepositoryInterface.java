package com.ihm.timetablemanagement.repositories;

import com.ihm.timetablemanagement.models.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LevelRepositoryInterface extends JpaRepository<Level, UUID> {
}
