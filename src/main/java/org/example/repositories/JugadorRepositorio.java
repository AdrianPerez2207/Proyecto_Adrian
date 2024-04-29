package org.example.repositories;

import org.example.HibernateUtil;
import org.example.models.Jugador;
import org.hibernate.Session;

import java.util.List;

public class JugadorRepositorio {

    private Session session;
    public JugadorRepositorio() {
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public void closeSession(){
        this.session.close();
    }

    /**
     * Método para insertar un jugador sin id
     * @param jugador
     */

    public void insert(Jugador jugador){
        session.beginTransaction();

        session.persist(jugador);

        session.getTransaction().commit();
    }

    /**
     * Buscar Jugador por Id
     * @param id
     * @return devuelve el jugador que coincida con la Id
     */
    public Jugador findById(Long id){
        return session.find(Jugador.class, id);
    }
    public List<Jugador> findAll(){
        return session.createQuery("select j from Jugador j", Jugador.class).list();
    }

    /**
     * Sin recuperar de la base de datos.
     * @param jugador
     */
    public void update(Jugador jugador){
        session.beginTransaction();

        session.merge(jugador);

        session.getTransaction().commit();
    }
    public void delete(Jugador jugador){
        session.beginTransaction();

        session.remove(jugador);

        session.getTransaction().commit();
    }

}
