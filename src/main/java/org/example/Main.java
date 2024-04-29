package org.example;

import org.example.models.Juego;
import org.example.models.Jugador;
import org.example.repositories.JugadorRepositorio;

public class Main {

    public static void main(String[] args) {

        Jugador j1 = new Jugador("Adrian", "Norteño", 27, "adrian@gmail.com", "Español",
                "España");
        Jugador j2 = new Jugador("Gabriel", "Comparitiko", 23, "gabriel@gmail.com", "Español",
                "España");
        Jugador j3 = new Jugador("Robert", "Topeto", 28, "Robert@gmail.com", "Ruso",
                "Rusia");
        Jugador j4 = new Jugador("Alejandro", "AlexRed", 25, "alejandro@gmail.com", "Alemán",
                "Alemania");

        JugadorRepositorio jr = new JugadorRepositorio();
        jr.insert(j1);
        jr.insert(j2);
        jr.insert(j3);
        jr.insert(j4);

        jr.closeSession();
    }
}