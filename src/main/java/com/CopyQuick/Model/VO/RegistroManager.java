/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import com.CopyQuick.Model.DAO.*;

/**
 *
 * @author PC02
 */
public class RegistroManager {
    DAO_Registro dr = new DAO_Registro();
    
    public boolean insertRegistro(Registro regist) {
        return dr.InsertObject(regist);
    }
    
    public Registro findRegistro(Registro regist){
        return dr.findRegistro(regist);
    }
    
}
