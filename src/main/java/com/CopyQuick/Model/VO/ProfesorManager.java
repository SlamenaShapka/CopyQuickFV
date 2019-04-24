/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import com.CopyQuick.Controller.Utils;
import com.CopyQuick.Model.DAO.DAO_Profesor;

/**
 *
 * @author PC02
 */
public class ProfesorManager {
    
    public String insertEstudent(Profesor prof){
        DAO_Profesor dp = new DAO_Profesor();
        dp.InsertObject(prof);
        return Utils.toJson(prof);
    }
    
}
