/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.DAO;

import com.CopyQuick.Model.DAO.*;
import com.CopyQuick.Model.VO.*;
import java.util.List;

/**
 *
 * @author PC02
 */
public class main {
    public static void main(String arg[]){
        EstudianteManager em = new EstudianteManager();
        Usuario user = new Usuario();
        
        user.setNomUsuario("Slamena");
        user.setContrasena("Shapka");
        user.setTipo("Estudiante");
        
        Estudiante est = em.findEstByNomUser(user);
        
        System.out.println(est.getSaldo());
    }
}
