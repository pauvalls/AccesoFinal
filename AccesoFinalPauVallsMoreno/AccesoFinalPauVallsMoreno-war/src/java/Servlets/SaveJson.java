/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Questions;
import Entidades.Useranswers;
import Entidades.Userdata;
import Entidades.Userexams;
import Entidades.Userquestions;
import EntidadesS.OptionsFacade;
import EntidadesS.QuestionsFacade;
import EntidadesS.UseranswersFacade;
import EntidadesS.UserdataFacade;
import EntidadesS.UserexamsFacade;
import EntidadesS.UserquestionsFacade;
import Utilities.ParseExam;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pauva
 */
public class SaveJson extends HttpServlet {

    @EJB
    private QuestionsFacade questionsFacade;

    @EJB
    private UseranswersFacade useranswersFacade;

    @EJB
    private UserquestionsFacade userquestionsFacade;

    @EJB
    private UserdataFacade userdataFacade;

    @EJB
    private UserexamsFacade userexamsFacade;

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
            out.println("<title>Servlet SaveJson</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SaveJson at " + request.getParameter("data") + "</h1>");
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
        // processRequest(request, response);
        PrintWriter out = response.getWriter();

        response.setContentType("application/json");
        //  String s= request.getParameter("company");
        out.print(request.getParameter("company"));
        //   System.out.println(s);
        Gson gson = new Gson();
//        String lista= gson.toJson(request.getParameter("company"));
//        System.out.println(s);
        ParseExam[] pE = gson.fromJson(request.getParameter("company"), ParseExam[].class);
        for (ParseExam u : pE) {
            response.getWriter().print(u.getName() + "  -  " + u.getValue() + "\n");
        }

        Userexams usr = new Userexams();
        List<Userdata> userdata = userdataFacade.findAll();
        Userdata userdef = userdata.get(0);
        Userexams exam = new Userexams(userdef.getUserdataId().toString(), new Date(), new Date());
        userexamsFacade.create(exam);
        Questions  quest=null;
        Userquestions uq = null; 
        for (ParseExam u : pE) {
            Questions q = questionsFacade.find(u.getName());
            if (!q.equals(quest)) {
                uq = new Userquestions();
            uq.setUserquestionsIdexam(exam);
            uq.setUserquestionsIdquestion(q);
            userquestionsFacade.create(uq);
            }
            
            Useranswers usw = new Useranswers();
            usw.setUseranswersIdquestion(uq);
            usw.setUserquestionsAnswer(u.getValue());
            useranswersFacade.create(usw);
            quest=q;
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
