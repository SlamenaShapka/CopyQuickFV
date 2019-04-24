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

    public void insertEstudent(Estudiante est) {
        DAO_Estudiante de = new DAO_Estudiante();
        de.InsertObject(est);
    }

}
