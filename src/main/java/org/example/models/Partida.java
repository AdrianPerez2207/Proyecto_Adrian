package org.example.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Partida {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private LocalTime hora;

    private Double duracion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_ganador_id")
    private Jugador ganadorPartida;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "partida_jugador",
            joinColumns = @JoinColumn(name = "partida_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id")
    )
    private List<Jugador> participantes;


    public Partida(LocalDate fecha, LocalTime hora, Double duracion) {
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }
}
