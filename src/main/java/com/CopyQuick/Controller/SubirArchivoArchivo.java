/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.CopyQuick.Controller;

import com.google.protobuf.Timestamp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author PC02
 */
public class SubirArchivoArchivo extends HttpServlet {
private final static Logger LOGGER =
			Logger.getLogger(SubirArchivoArchivo.class.getCanonicalName());

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		   String id = request.getParameter("filename");
		   
		   
		    // Create path components to save the file
		    String 	path = "C:\\Users\\daniel rubio\\Downloads"; //Carpeta en el sistema de az archivos donde estÃ¡ el archivo.
		    

	         String fileName = path+id;
	         String fileType = "document/pdf";
	         // Find this file id in database to get file name, and file type

	         // You must tell the browser the file type you are going to send
	         // for example application/pdf, text/plain, text/html, image/jpg
	         response.setContentType(fileType);

	         // Make sure to show the download dialog
	         response.setHeader("Content-disposition","attachment; filename="+id);

	         // Assume file name is retrieved from database
	         // For example D:\\file\\test.pdf

	         File my_file = new File(fileName);

	         // This should send the file to browser
	         OutputStream out = response.getOutputStream();
	         FileInputStream in = new FileInputStream(my_file);
	         byte[] buffer = new byte[4096];
	         int length;
	         while ((length = in.read(buffer)) > 0){
	            out.write(buffer, 0, length);
	         }
	         in.close();
	         out.flush();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String	path = "C:\\Users\\PC02\\Desktop\\ArchivosCopyQuick\\";
	   
	   //Guardar el nombre del archivo basado en la hora para evitar que se repitan los nombres de los archivos.
	    final Part filePart = request.getPart("file");
	    final String fileName = getFileName(filePart);
            
            System.out.println(fileName);
            
	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();

	    try {
	        out = new FileOutputStream(new File(path + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        writer.println(fileName);
	        
	        
	    } catch (FileNotFoundException fne) {
	        writer.println("<br/> ERROR: " + fne.getMessage());

	       
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
		
	}
	
	protected void processRequest(HttpServletRequest request,
	        HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	   
	    	
	    
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
