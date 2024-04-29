package org.example.repositories;

import org.example.HibernateUtil;
import org.example.models.Juego;
import org.example.models.Partida;
import org.hibernate.Session;

import java.util.List;

public class PartidaRepositorio {

    private Session session;

    public PartidaRepositorio() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession(){
        this.session.close();
    }

    public void insert(Partida partida){
        session.beginTransaction();

        session.persist(partida);

        session.getTransaction().commit();
    }

    public Partida findById(Long id){
        return session.find(Partida.class, id);
    }

    public List<Partida> findAll(){
        return session.createQuery("select p from Partida p", Partida.class).list();
    }

    public void update(Partida partida){
        session.beginTransaction();

        session.merge(partida);

        session.getTransaction().commit();
    }

    public void delete(Partida partida){
        session.beginTransaction();

        session.remove(partida);

        session.getTransaction().commit();
    }
}
