/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Controller;

import com.CopyQuick.Model.VO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC02
 */
public class ServletArchivos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArchivoManager am = new ArchivoManager();
        List<Archivo> archivos = am.findFiles();
        String archivo = archivos.get(0).getIdArchivo() + "," + archivos.get(0).getNombre()
                + "," + archivos.get(0).getNomUsuario().getNomUsuario() + "," + archivos.get(0).getSemestre();
        for (int i = 1; i < archivos.size(); i++) {
            archivo = archivo.concat("-" + archivos.get(i).getIdArchivo() + "," + archivos.get(i).getNombre()
                    + "," + archivos.get(i).getNomUsuario().getNomUsuario() + "," + archivos.get(i).getSemestre());
        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(archivo);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String id = Utils.readParams(request);
            Archivo a = new Archivo();
            id = id.substring(id.indexOf("=")+1);
            a.setIdArchivo(Integer.parseInt(id));
            ArchivoManager am = new ArchivoManager();
            
            a=am.findFile(a);
            
            if(a != null){
                response.sendRedirect("ArchivoEscogido.jsp");
            }else{
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("ContrasenaIncorrecta");
                }
            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
