/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localhost.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "JurosSimples", urlPatterns = {"/juros-simples"})
public class JurosSimples extends HttpServlet {

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
            //   INÍCIO DO HTML
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros simples</title>");
            out.println("<style>");
            out.println("#nav{"
                    + "background-color: #8ee5ee;"
                    + "border: 1px solid black;"
                    + "margin: 0;"
                    + "padding: 0;"
                    + "font-family: sans-serif, century-gothic;"
                    + "}");
            
            out.println("#center{"
                    + "margin-top: 10px;"  
                    + "padding: auto;"
                    + "font-family: sans-serif, century-gothic;"
                    + "}");
            
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id = 'nav'>");
            out.println("<CENTER><h1>Juros Simples<h1></CENTER>");
            out.println("</div>");
            
            out.println("<div id= 'center'>");
           
            //início do form
            out.println("<form>");
            out.println("<CENTER>Capital Social: <div><input type='text' step=\'0.01\' name='valcapital' placeholder='Digite o capital inicial'><BR></div></CENTER>");
            out.println("<p></p>");
            out.println("<CENTER>Taxa de Juros <div><input type='text' step=\'0.01\' name='valtaxa' placeholder='Digite taxa de juros'><BR></div><CENTER>");
            out.println("<p></p>");
            out.println("<CENTER>Tempo de parcela: <div><input type='text' step=\'0.01\' name='valtempo' placeholder='Digite tempo de parcela'><BR></div><CENTER>");
            out.println("<CENTER><p><div><input type='submit' value='Enviar'><BR></div></p><CENTER>");
            
            
            //TRATAMENTO DAS VARIÁVEIS
            try{
                    if (request.getParameter("valcapital") != null || request.getParameter("valtaxa") != null || request.getParameter("valtempo") != null)
                    {
                        double capital = Double.parseDouble(request.getParameter("valcapital"));
                        double taxa = Double.parseDouble(request.getParameter("valtaxa"));
                        double tempo = Double.parseDouble(request.getParameter("valtempo"));
                        double juros = capital * (taxa / 100) * tempo;
                        double montante = capital + juros;
                        out.println("<br>");

                        //SAÍDA E FIM DO FORM
                        out.println("<CENTER> sendo o capital inicial de "+ capital +", o montante será de: " + montante +" à juros simples.</CENTER>");

                        out.println("</form>");
                        out.println("<br><br>");
                        out.println("<a href = 'home'>Voltar à tela inicial</a>");
                    }
            }
            catch(Exception e)
            {
               out.println("<span><h2 style= 'color:red'>erro! Digite apenas números</h2></span>");
            }                 
            
            out.println("</div>");
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
