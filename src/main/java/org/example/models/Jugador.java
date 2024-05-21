package org.example.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_preferido_id")
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

    /**
     * Pintamos todos los campos menos las relaciones, en este caso el Juego preferido
     * @return
     */

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Jugador{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", alias='").append(alias).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", email='").append(email).append('\'');
        sb.append(", idioma='").append(idioma).append('\'');
        sb.append(", pais='").append(pais).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
