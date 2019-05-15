/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Controller;

import com.CopyQuick.Model.VO.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PC02
 */
public class ServletRegistroQR extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletRegistroQR</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletRegistroQR at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String idRegistro = Utils.readParams(request);
        RegistroManager rm = new RegistroManager();
        Registro regist = new Registro();

        regist.setIdRegistro(Integer.parseInt(idRegistro));

        Registro rgsDB = rm.findRegistro(regist);

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
        String[] json = null;
        json = (Utils.readParams(request)).split(",");
        json[0] = json[0].substring(1);
        json[json.length - 1] = json[json.length - 1].substring(0, json[json.length - 1].length() - 1);
        String[][] datos = new String[json.length][2];
        for (int i = 0; i < json.length; i++) {
            String[] split = json[i].split(":");
            datos[i][0] = split[0];
            datos[i][1] = split[1].substring(1, split[1].length() - 1);
        }

        RegistroManager rm = new RegistroManager();
        ArchivoManager am = new ArchivoManager();
        EstudianteManager em = new EstudianteManager();

        Archivo file = new Archivo();
        file.setIdArchivo(Integer.parseInt(datos[0][1]));

        Archivo fileBD = am.findFile(file);

        Registro regist = new Registro();

        java.util.Date fecha = new Date();

        regist.setFecha(fecha);
        regist.setPaginaFin(Integer.parseInt(datos[2][1]));
        regist.setPaginaIni(Integer.parseInt(datos[1][1]));
        regist.setUsuarioFinal(datos[3][1]);
        regist.setVigencia(true);
        regist.setIdArchivo(file);
        Usuario user = new Usuario();
        user.setNomUsuario(datos[3][1]);
        regist.setNomUsuario(user);
        
        if (regist.getPaginaFin() <= fileBD.getNumHojas()) {
            regist.setPrecio((regist.getPaginaFin() - (regist.getPaginaIni()-1)) * 100);
        } else {
            regist.setPrecio((fileBD.getNumHojas() - (regist.getPaginaIni()-1)) * 100);
        }

        Estudiante est = em.findEstByNomUser(user);

        if (regist.getPrecio() <= est.getSaldo()) {
            if (rm.insertRegistro(regist)) {                                          //El registro se creo satisfactoriamente.
                try (PrintWriter out = response.getWriter()) {
                    out.println(regist.getIdRegistro());
                }
            } else {                                                                  //El registro no se pudo crear.
                try (PrintWriter out = response.getWriter()) {
                    out.println("Error");
                }
            }
        } else {
            try (PrintWriter out = response.getWriter()) {
                out.println("SaldoInsuficiente");
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
