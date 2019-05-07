/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.DAO;

import com.CopyQuick.Model.VO.*;
import com.CopyQuick.Persistence.EMF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author CopyQuick.
 */
public class DAO_Archivo {
    
    public EntityManager em = null;
    
    public ArrayList<Archivo> findFiles(){
        em = EMF.get().createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT a FROM Archivo a WHERE publico=1");
        return (ArrayList<Archivo>) query.getResultList();
    }
    
    public Archivo findFile(Archivo file) {

        try {
            em = EMF.get().createEntityManager();
            em.getTransaction().begin(); //inicia conexión
            Archivo a = em.find(Archivo.class, file.getIdArchivo());
            em.close();
            return a;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }
    
    public boolean InsertObject(Archivo a) {
        try {
            em = EMF.get().createEntityManager();
            em.getTransaction().begin(); //inicia conexión
            em.persist(a);
            em.getTransaction().commit();
            em.refresh(a);
            em.close();
            return true;

        } catch (Exception e) {
            return false;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }
}
