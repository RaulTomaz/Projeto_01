/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localhost.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raul
 */
@WebServlet(name = "JurosComposto", urlPatterns = {"/juros-composto"})
public class JurosComposto extends HttpServlet {

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
             throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Juros Compostos</title>"); 
            
            //definindo estilo para tabelas e divs
            out.println("<style>");
            out.println("table, tr, td, th{"
                    + "border: 1px solid black;"
                    + "margin: auto;"
                    + "padding: auto;"
                    + "}");
            
            out.println("#nav{"
                    + "background-color: #8ee5ee;"
                    + "border: 1px solid black;"
                    + "margin: auto;"
                    + "padding: auto;"
                    + "display:  block;"
                    + "font-family: sans-serif, century-gothic;"
                    + "clear: both;"
                    + "}");
            
            out.println("#center{"
                    + "margin: auto;"
                    + "margin-top: 10px;"
                    + "padding: auto;"
                    + "text-align: center;"
                    + "display:  block;"
                    + "position: inline;"
                    + "font-family: sans-serif, century-gothic;"
                    + "}");
            
            out.println("#center-2{"
                    + "margin: auto;"
                    + "padding: auto;"
                    + "text-align: center;"
                    + "display:  block;"
                    + "position: inline;"
                    + "font-family: sans-serif, century-gothic;"
                    + "}");
            
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div id=  'nav'>");
            out.println("<h1><center>Juros Compostos</center></h1>");
            out.println("</div>");
            
            //Criando div e formulário para entrada de dados
            out.println("<div id = 'center'>");
            out.println("<form name= 'frmComp' method= 'POST' value=''/>");            
            out.println("Capital inicial: <input type='text' name= 'txtCapital' value= '0'/>");
            out.println("Tempo total: <input type='text' name= 'txtTempo' value= '0'/> meses");             
            out.println("<br><br>");
            out.println("<div id= 'center-2'>");
            out.println("Taxa proporcional: <select name='cmbTaxa'>"
                    + "<option value= 'aoDia'>ao dia</option>"
                    + "<option value= 'aoMes'>ao mês</option>"
                    + "<option value= 'aoAno'>ao ano</option>"
                    + "<option value= 'aoBi'>ao bimestre</option>"
                    + "<option value= 'aoTri'>ao trimestre</option>"
                    + "<option value= 'aoSe'>ao semestre</option>"
                    + "</select>"); 
            out.println("Taxa de juros: <input type='text' name= 'txtTaxa' value= '0' size= '21'/> %");
            out.println("</div>");
            out.println("<br>");
            out.println("<input type= 'submit' name= 'btnCalcular' value= 'Calcular'/>");
            
            //criando classe de formatação decimal (apenas duas casas após vírgula)
            DecimalFormat formata = new DecimalFormat("###,###,###,###,###.##");
            
            //criando variaveis principais
            double Montante = 0;
            double percentualTaxa = 0;
            
            //capturando e convertendo variavel do input Capital (apenas números)
            try
            {
                if (request.getParameter("txtCapital") != null || request.getParameter("txtTempo") != null || request.getParameter("txtTaxa") != null)
                {
                    String capital = request.getParameter("txtCapital");
                    double capitalConvertido = 0;
                    capitalConvertido = Double.parseDouble(capital);

                    //capturando e convertendo variavel do input tempo total
                    String tempo = request.getParameter("txtTempo");
                    double tempoConvertido = 0;
                    tempoConvertido = Double.parseDouble(tempo); 

                    //capturando valor dentro de select (comboBox)
                    String taxaTipo = request.getParameter("cmbTaxa");

                    //capturando e convertendo valor de input Taxa de Juros
                    String taxaJuros = request.getParameter("txtTaxa");
                    double taxaJurosConvertido = 0;
                    taxaJurosConvertido = Double.parseDouble(taxaJuros);

                    //conversão de taxas para associar com o período
                    if (taxaTipo.equals("aoDia"))
                    {
                        taxaJurosConvertido = taxaJurosConvertido * 30;
                    }
                    else if (taxaTipo.equals("aoAno"))
                    {
                        taxaJurosConvertido = taxaJurosConvertido / 12;
                    }
                    else if (taxaTipo.equals("aoBi"))
                    {
                        taxaJurosConvertido = taxaJurosConvertido / 2;
                    }
                    else if (taxaTipo.equals("aoTri"))
                    {
                        taxaJurosConvertido = taxaJurosConvertido / 3;
                    }
                    else if (taxaTipo.equals("aoSe"))
                    {
                        taxaJurosConvertido = taxaJurosConvertido / 6;
                    }
                    /*else
                    {
                        taxaJurosConvertido = taxaJurosConvertido;
                    }*/

                    //Somando taxa de juros + 1
                    percentualTaxa = 1 + (taxaJurosConvertido / 100);

                    //aplicando a fórmula do montante dentro da tabela
                    out.println("<br><br>");
                              
                        out.println("<table>");
                        out.println("<tr>");
                        out.println("<th>Índice</th>");
                        out.println("<th>Montante</th>");
                        out.println("</tr>");

                        out.println("<tr>");
                        for (int i = 1; i <= tempoConvertido; i++)
                        { 
                            Montante = capitalConvertido * (Math.pow(percentualTaxa, i));
                            out.println("<td>"+i+"º período</td>");
                            out.println("<td>"+formata.format(Montante)+"</td>");
                            out.println("</tr>");
                            
                        }
                        out.println("</table>");
                        out.println("<br><br>");
                        out.println("<a href = 'home'>Voltar à tela inicial</a>");
                }
            }
            catch(Exception e)
            {
                out.println("<span><h2 style= 'color = 'red';'>erro! Digite apenas números</h2></span>");
            }
            
            out.println("</form>");
            
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
