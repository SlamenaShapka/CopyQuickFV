/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.DAO;

import com.CopyQuick.Model.VO.*;
import com.CopyQuick.Persistence.EMF;
import javax.persistence.EntityManager;

/**
 *
 * @author PC02
 */
public class DAO_Registro {
    
    public EntityManager em = null;
    
    public boolean InsertObject(Registro u) {
        try {
            em = EMF.get().createEntityManager();
            em.getTransaction().begin(); //inicia conexión
            em.persist(u);
            em.getTransaction().commit();
            em.refresh(u);
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

    public Registro findRegistro(Registro user) {

        try {
            em = EMF.get().createEntityManager();
            em.getTransaction().begin(); //inicia conexión
            Registro u = em.find(Registro.class, user.getIdRegistro());
            em.close();
            return u;
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

    }
    
}
