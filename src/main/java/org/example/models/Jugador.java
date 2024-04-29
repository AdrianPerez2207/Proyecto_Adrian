package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Jugador {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column (unique = true)
    private String alias;

    private Integer edad;

    @Column( unique = true)
    private String email;

    private String idioma;

    @ManyToOne
    //@JoinColumn(name = "juego_preferido_id")
    private Juego juegoPreferido;

    private String pais;

    public Jugador(String nombre, String alias, Integer edad,
                   String email, String idioma, String pais) {
        this.nombre = nombre;
        this.alias = alias;
        this.edad = edad;
        this.email = email;
        this.idioma = idioma;
        this.pais = pais;
    }
}
