/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas
 */
@WebServlet(urlPatterns = {"/CalculaIMC"})
public class CalculaIMC extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public float CalculaIMC(int p, float a){

		return p/(a*a);
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int peso = Integer.parseInt(request.getParameter("peso"));
        float altura = Float.parseFloat(request.getParameter("altura"));

        float resultado = CalculaIMC(peso, altura);
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
	    out.println("<head>");
            out.println("<title>Desafio 1</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>Desafio 1  - Resultado IMC</h1>");
	    out.println("<br>");

            if(resultado < 18.5){

		out.println("<p> Resultado = " +resultado+ "</p><br>");
		out.println("<p> Você está abaixo do peso ideal</p><br>");
				
	    }
            
            else if (resultado >= 18.5 && resultado < 25.0) {

		out.println("<p> Resultado = " +resultado+ "</p><br>");
		out.println("<p> Peso ideal</p><br>");
				
            }

	    else if (resultado >= 25.0 && resultado < 30.0) {

		out.println("<p> Resultado = " +resultado+ "</p><br>");
		out.println("<p> Sobrepeso</p><br>");
				
	    }

	    else if (resultado >= 30.0 && resultado < 35.0) {

		out.println("<p> Resultado = " +resultado+ "</p><br>");
		out.println("<p> Obesidade Grau I</p><br>");
				
	    }

	    else if (resultado >= 35.0 && resultado < 40.0) {

		out.println("<p> Resultado = " +resultado+ "</p><br>");
	        out.println("<p> Obesidade Grau II</p><br>");
				
            }

	    else if (resultado >= 40.0) {

		out.println("<p> Resultado = " +resultado+ "</p><br>");
		out.println("<p> Obesidade Grau III</p><br>");
				
	   }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
