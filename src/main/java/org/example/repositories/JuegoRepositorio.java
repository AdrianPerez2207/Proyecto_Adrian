package org.example.repositories;

import org.example.HibernateUtil;
import org.example.models.Juego;
import org.example.models.Jugador;
import org.hibernate.Session;

import java.util.List;

public class JuegoRepositorio {

    private Session session;

    public JuegoRepositorio() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession(){
        this.session.close();
    }

    public void insert(Juego juego){
        session.beginTransaction();

        session.persist(juego);

        session.getTransaction().commit();
    }

    public Juego findById(Long id){
        return session.find(Juego.class, id);
    }

    public List<Juego> findAll(){
        return session.createQuery("select j1 from Juego j1", Juego.class).list();
    }

    public void update(Juego juego){
        session.beginTransaction();

        session.merge(juego);

        session.getTransaction().commit();
    }

    public void delete(Juego juego){
        session.beginTransaction();

        session.remove(juego);

        session.getTransaction().commit();
    }
}
