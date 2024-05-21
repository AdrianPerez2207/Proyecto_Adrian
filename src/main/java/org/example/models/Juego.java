package org.example.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Juego {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String plataforma;

    private Integer pegi; //Edad recomendada

    @Enumerated(value = EnumType.STRING)
    private Categoria categoria;

    public Juego(String nombre, String plataforma, Integer pegi, Categoria categoria) {
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.pegi = pegi;
        this.categoria = categoria;
    }
}
