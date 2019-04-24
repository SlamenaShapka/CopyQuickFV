/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Model.VO;

import com.CopyQuick.Model.DAO.DAO_Archivo;
import com.CopyQuick.Controller.Utils;
import java.util.ArrayList;

/**
 *
 * @author PC02
 */
public class ArchivoManager {
    
    DAO_Archivo da = new DAO_Archivo();;
    
    public ArrayList<Archivo> findFiles(){
        return da.findFiles();
    }
    
    public Archivo findFile(Archivo archivo){
        return da.findFile(archivo);
    }
    
    public boolean insertFile(Archivo archivo){
        return da.InsertObject(archivo);
    }
    
}
