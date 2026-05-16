package com.tuempresa.centrodeportivo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String rol; // Ejemplo: "ADMIN", "ATLETA"

    // Relación ManyToOne: Muchos usuarios pertenecen a un plan
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id")
    private Plan plan;

    // Relación ManyToMany: Un usuario asiste a muchas clases (lado inverso)
    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Clase> clases;
}