package com.ihm.timetablemanagement.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "establishment")
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "establishment_id")
    private UUID establishmentId;

    @Column(name = "name", nullable = false, length = 127, unique = true)
    private String name;

    @Column(name = "address", nullable = false, length = 254)
    private String address;
}
