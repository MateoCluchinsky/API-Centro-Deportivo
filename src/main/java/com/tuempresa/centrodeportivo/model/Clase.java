package com.tuempresa.centrodeportivo.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clases")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Clase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre; // Ej: "CrossFit Local"

    @Column(nullable = false)
    private LocalDateTime horario;

    @Column(nullable = false)
    private Integer cupoMaximo;

    // Relación ManyToMany: Una clase tiene muchos usuarios inscritos (lado dueño)
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "clase_usuario", joinColumns = @JoinColumn(name = "clase_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios;
}