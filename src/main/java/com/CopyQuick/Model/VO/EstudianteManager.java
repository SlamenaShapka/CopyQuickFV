/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import com.CopyQuick.Controller.Utils;
import com.CopyQuick.Model.DAO.DAO_Estudiante;

/**
 *
 * @author PC02
 */
public class EstudianteManager {
    
    DAO_Estudiante de = new DAO_Estudiante();;

    public void insertEstudent(Estudiante est) {
        de.InsertObject(est);
    }
    
    public Estudiante findEstByNomUser(Usuario user){
        return de.findEstByNomUser(user).get(0);
    }

}
