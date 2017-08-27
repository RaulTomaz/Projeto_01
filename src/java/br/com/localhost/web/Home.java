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
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

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
            out.println("<title>Projeto da equipe número 1</title>");
            out.println("<style>");
            out.println("#nav{"
                    + "background-color: #8ee5ee;"
                    + "height: 100%;"
                    + "border: 1px solid black;"
                    + "font-family: sans-serif, century-gothic;"
                    + "margin:0;"
                    + "padding:0;"
                    + "}");
            out.println("#center{"
                    + "height:100%;"
                    + "width:100%;"
                    + "margin:0;"
                    + "padding:0;"
                    + "font-family: sans-serif, century-gothic;"
                    + "}");
            
            out.println("table, tr, th, td{"
                    + "margin: auto;"
                    + "border: 1px solid black;"
                    + "}");
            
            out.println("body{"
                    + "margin:0;"
                    + "padding:0;"
                    + "}");
           
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id='nav'>");
            out.println("<h1><center>Equipe número 1</center></h1>");
            out.println("</div>");
            out.println("<div id='center'>");
            out.println("<h1>Integrantes:</h1>");
            out.println("<h3>Bryan Ichiro Higa - 4º ciclo</h3>");
            out.println("<h3>Danilo Pelozoni - 4º ciclo</h3>");
            out.println("<h3>Leonardo Umbelino - 4º ciclo</h3>");
            out.println("<h3>Raul Tomaz - 4º ciclo</h3>");
            out.println("<h2><center>Tabela de taxas proporcionais"
                    + " (mais utilizadas): </center></h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Conceito</th>");
            out.println("<th>Fórmula</th>");
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("<td><center>taxa a.m para dia</center></td>");
            out.println("<td><center>taxa / 30</center></td>");
            out.println("</tr>");
            out.println("<td><center>taxa a.a para mês</center></td>");
            out.println("<td><center>taxa / 12</center></td>");
            out.println("</tr>");
            out.println("<td><center>taxa a.d para mês</center></td>");
            out.println("<td><center>taxa * 30</center></td>");
            out.println("</tr>");
            out.println("<td><center>taxa a.b para mês</center></td>");
            out.println("<td><center>taxa / 2</center></td>");
            out.println("</tr>");
            out.println("<td><center>taxa a.t para mês</center></td>");
            out.println("<td><center>taxa / 3</center></td>");
            out.println("</tr>");
            out.println("<td><center>taxa a.s para mês</center></td>");
            out.println("<td><center>taxa / 6</center></td>");          
            out.println("</table>");
            
            out.println("<center><p>Aplicação de juros simples. Link: "
                    + "<a href='juros-simples'>Juros-simples</a></center> ");
            out.println("<center><p>Aplicação de juros compostos. Link: "
                    + "<a href='juros-composto'>Juros-compostos</a></center> ");
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
