package com.example.proyectofinal12.dao.impl;

import com.example.proyectofinal12.dao.ExpertDAO;
import com.example.proyectofinal12.model.Expert;
import com.example.proyectofinal12.model.Tag;
import com.example.proyectofinal12.util.HibernateUtil;
import org.hibernate.Cache;
import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.Instant;
import java.util.List;

@Repository
public class ExpertDAOImp implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;

/*
    @Autowired
    private Session session;
*/

/*    @Override
    public List<Expert> findAllFromSession() {
        return session.createQuery("from Expert e").list();
    }*/

    @Override
    public Expert createExpert(Expert expertToCreate) {
/*
        System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println(expertToCreate);
        System.out.println(expertToCreate.getNombre());

        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();


        Expert newExpert = new Expert();

        newExpert.setNombre(expertToCreate.getNombre());
        newExpert.setTelefono(expertToCreate.getTelefono());


        if(expertToCreate.getNif() != null)
            newExpert.setNif(expertToCreate.getNif());

        if(expertToCreate.getDisponibilidad() != null)
            newExpert.setDisponibilidad(expertToCreate.getDisponibilidad());

        if(expertToCreate.getEstado() != null)
            newExpert.setEstado(expertToCreate.getEstado());

        if(expertToCreate.getPuntuacion() != null)
            newExpert.setPuntuacion(expertToCreate.getPuntuacion());


        if(expertToCreate.getCorreo() != null)
            newExpert.setCorreo(expertToCreate.getCorreo());

        if(expertToCreate.getDireccion() != null)
            newExpert.setDireccion(expertToCreate.getDireccion());

        if(expertToCreate.getObservaciones() != null)
            newExpert.setObservaciones(expertToCreate.getObservaciones());

        if(expertToCreate.getEstadoMotivo()!= null)
            newExpert.setEstadoMotivo(expertToCreate.getEstadoMotivo());

        newExpert.setCreatedDate(Instant.now());
        newExpert.setLast_updated(Instant.now());

        session.save(newExpert);

        session.getTransaction().commit();

        session.close();

        return newExpert;*/
        return  null;
    }

    @Override
    public Expert modifyExpert(Expert modifiedExpert, Expert findedExpert, Tag getNewTag, List existingTags) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        findedExpert.setNombre(modifiedExpert.getNombre());
        findedExpert.setNif(modifiedExpert.getNif());
        findedExpert.setDisponibilidad(modifiedExpert.getDisponibilidad());

        //añadimos etiqueta nueva a la lista de etiquetas
        if(getNewTag != null)
            existingTags.add(getNewTag);
            findedExpert.setTags(existingTags);

        findedExpert.setDisponibilidad(modifiedExpert.getDisponibilidad());
        findedExpert.setLast_updated(Instant.now());

        session.update(findedExpert);
        session.getTransaction().commit();
        session.close();

        return findedExpert;*/
        return null;
    }

    @Override
    public  Expert updateExpert(Expert modifiedExpert, Expert findedExpert, Tag findedTag, List<Tag> existingTags){
       /* Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();


        if(modifiedExpert.getNombre() != null)
            findedExpert.setNombre(modifiedExpert.getNombre());

        if(modifiedExpert.getNif() != null)
            findedExpert.setNif(modifiedExpert.getNif());

        if(modifiedExpert.getDisponibilidad() != null)
            findedExpert.setDisponibilidad(modifiedExpert.getDisponibilidad());

        if(modifiedExpert.getEstado() != null)
        findedExpert.setEstado(modifiedExpert.getEstado());

        if(modifiedExpert.getPuntuacion() != null)
            findedExpert.setPuntuacion(modifiedExpert.getPuntuacion());

        if(modifiedExpert.getTelefono() != null )
            findedExpert.setTelefono(modifiedExpert.getTelefono());

        if(modifiedExpert.getCorreo() != null)
            findedExpert.setCorreo(modifiedExpert.getCorreo());

        if(modifiedExpert.getDireccion() != null)
            findedExpert.setDireccion(modifiedExpert.getDireccion());

        if(modifiedExpert.getObservaciones() != null)
            findedExpert.setObservaciones(modifiedExpert.getObservaciones());

        if(modifiedExpert.getEstadoMotivo() != null)
            findedExpert.setEstadoMotivo(modifiedExpert.getEstadoMotivo());

        //comprobamos si hay etiquetas que añadir

        if (findedTag.getName() != null) {
            existingTags.add(findedTag);
            findedExpert.setTags(existingTags);
        }

        findedExpert.setLast_updated(Instant.now());

        session.update(findedExpert);
        session.getTransaction().commit();
        session.close();


        // System.out.println(modifiedExpert.getTags());
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        return modifiedExpert;*/
        return null;

    }



    @Override
    public List<Expert> findAll(){
/*       Session session = HibernateUtil.getSessionFactory().openSession();

        return session.createQuery("from Expert", Expert.class ).list();*/
        return null;

    }

//    @Override
//    public Expert findById(Long id){
//
//        Session session = HibernateUtil.getSessionFactory().openSession();
//
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
//        Root<Expert> root = criteria.from(Expert.class);
//
//        criteria.where(builder.equal(root.get("id"), id));
//
//        Expert expert = session.createQuery(criteria).uniqueResult();
//
//        session.close();
//
//        return expert;
//    }

    @Override
    public Expert findById(Long id){
/*
        Session session = HibernateUtil.getSessionFactory().openSession();

        String hql = "FROM Expert e WHERE e.id = :id"; // named parameters
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        Expert expert = (Expert) query.getSingleResult();

        session.close();

        return expert;*/



        Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        criteria.select(root);

        criteria.where(builder.equal(root.get("id"), id));

        // Opcion 1
        // List<Company> companies = session.createQuery(criteria).list();
        // System.out.println(companies);

        // Opcion 2
        Expert expert = session.createQuery(criteria).getSingleResult();
        System.out.println(expert);
        session.close();

        return expert;


    }

    @Override
    public List<Expert> findAllByName(String name) {
      /*  Session session = HibernateUtil.getSessionFactory().openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        criteria.select(root);
        criteria.where(builder.like(root.get("nombre"), "%"+name+"%"));

        List<Expert> experts = session.createQuery(criteria).list();

        session.close();

        return experts;*/
        return null;

    }

    @Override
    public List<Expert> findAllByFilter(String nombre, String estado, String tamano, String pagina) {
        /*Session session = HibernateUtil.getSessionFactory().openSession();


        String hql = "FROM Expert WHERE nombre LIKE :nombre AND estado LIKE :estado";
        System.out.println(hql);
        Query query = session.createQuery(hql);

        query.setParameter("nombre", "%"+nombre+"%");
        query.setParameter("estado", "%"+estado+"%");

        //si quitas este devuelve all y permitiria paginar, sino se limita a enseñar lo que tiene
        if(pagina != null)
       query.setMaxResults(Integer.parseInt(tamano));

        List experts = query.getResultList();

        return experts;*/
        return null;

    }

    @Override
    public void deleteExpert(Expert expertToDelete){
     /*   Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.delete(expertToDelete);

        session.getTransaction().commit();
        session.close();*/

    }


    @Override
    public void deleteTagExpert(Tag listTag, Expert expert){

   /*     Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        System.out.println(expert);
        expert = session.find(Expert.class, expert.getId());
        System.out.println(expert);

        for (int x = 0; x < expert.getTags().size(); x++) {
            Tag t = expert.getTags().get(x);
            if (t.getName().equals(listTag.getName())) {
                  expert.getTags().remove(t);
                break;
            }
        }

         session.save(expert);
         session.getTransaction().commit();
         session.close();
        System.out.println(expert.getTags());*/


    }

}
