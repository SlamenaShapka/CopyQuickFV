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
        ArchivoManager am = new ArchivoManager();
        List<Archivo> archivos = am.findFiles();
        for(int i=0 ; i<archivos.size() ; i++){
            System.out.println(archivos.get(i).getNombre());
        }
    }
}
