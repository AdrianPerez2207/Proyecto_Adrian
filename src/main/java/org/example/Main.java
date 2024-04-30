package org.example;

import org.example.models.Juego;
import org.example.models.Jugador;
import org.example.repositories.JuegoRepositorio;
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

        JuegoRepositorio jrepositorio = new JuegoRepositorio();
        Juego juego1 = new Juego("Call of Duty", "PS4", 18);
        Juego juego2 = new Juego("Counter Strike", "PC", 18);
        Juego juego3 = new Juego("hunt Showdown", "PC", 18);

        //primero insertamos los juegos a JuegoRepositorio
        jrepositorio.insert(juego1);
        jrepositorio.insert(juego2);
        jrepositorio.insert(juego3);

        //Ahora, le añadimos el Juego preferido al jugador y con update lo modificamos
        j1.setJuegoPreferido(juego2);
        jr.update(j1);

        //Buscamos al jugador con la id y pintamos el juego preferido para verificar que se ha añadido
        System.out.println(jr.findById(1L).getJuegoPreferido());
        jr.closeSession();
        jrepositorio.closeSession();
    }
}