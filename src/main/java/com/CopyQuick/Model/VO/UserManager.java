/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import com.CopyQuick.Controller.Utils;
import com.CopyQuick.Model.DAO.DAO_Usuario;

/**
 *
 * @author Andrea Muñoz
 */
public class UserManager {
    DAO_Usuario du;

    public boolean insertUser(Usuario user) {
        du = new DAO_Usuario();
        return du.InsertObject(user);
    }
    
    public Usuario findUser(Usuario user){
        du = new DAO_Usuario();
        return du.findUser(user);
    }
}
