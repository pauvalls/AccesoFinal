/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Entidades.Answers;
import Entidades.Questions;
import Entidades.Useranswers;
import Entidades.Userdata;
import Entidades.Userexams;
import Entidades.Userquestions;
import EntidadesS.QuestionsFacade;
import EntidadesS.UserdataFacade;
import EntidadesS.UserexamsFacade;
import EntidadesS.UserquestionsFacade;
import Utilities.RespuestasOBJ;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class Correccion extends HttpServlet {

    @EJB
    private QuestionsFacade questionsFacade;

    @EJB
    private UserquestionsFacade userquestionsFacade;

    @EJB
    private UserexamsFacade userexamsFacade;

    @EJB
    private UserdataFacade userdataFacade;

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
            out.println("<title>Servlet Correccion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Correccion at " + request.getContextPath() + "</h1>");
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
        ArrayList<RespuestasOBJ> listaenvio = new ArrayList<>();
        
       List<Userexams> lista= userexamsFacade.findAll();
        Userexams uah= lista.get(lista.size()-1);
        response.getWriter().print("User id: " + uah.getUserexamsUserid() + " Examen: " + uah.getUserexamsId() + "\n");
        List<Userquestions> questions = (List<Userquestions>) uah.getUserquestionsList();
        for (Userquestions u : questions) {
            RespuestasOBJ robj = new RespuestasOBJ();
            List<Useranswers> ans = (List<Useranswers>) u.getUseranswersList();
          robj.setPregunta(u.getUserquestionsIdquestion().getQuestionsTitle());
            response.getWriter().print("Question: " + u.getUserquestionsIdquestion().getQuestionsTitle() + "\n");
            for (Useranswers a : ans) {
                response.getWriter().print("      Answer: " + a.getUserquestionsAnswer() + "\n");
            }
          //  response.getWriter().print(u.getUserquestionsIdquestion().getAnswersList().size() + " = " + u.getUseranswersList().size());
            if ( u.getUserquestionsIdquestion().getAnswersList().size() ==  u.getUseranswersList().size()) {
                boolean correcta = true;
                Collections.reverse( u.getUseranswersList());
                for (int i = 0; i != ((List<Answers>) u.getUserquestionsIdquestion().getAnswersList()).size(); i++) {
                 //  response.getWriter().print(((List<Answers>) u.getUserquestionsIdquestion().getAnswersList()).get(i).getAnswersAnswer() + " = " + ((List<Useranswers>) u.getUseranswersList()).get(i).getUserquestionsAnswer());
                    if (!((List<Answers>) u.getUserquestionsIdquestion().getAnswersList()).get(i).getAnswersAnswer().equals(((List<Useranswers>) u.getUseranswersList()).get(i).getUserquestionsAnswer())) {
                        correcta = false;
                    }
                }
                if (correcta) {
                    robj.setRespuesta("Correcta");
                    response.getWriter().print("Correcta   \n");
                    listaenvio.add(robj);
                } else {
                      robj.setRespuesta("Incorrecta");
                    response.getWriter().print("Incorrecta   \n");
                    listaenvio.add(robj);
                }
            } else {
                   robj.setRespuesta("Incorrecta");
                response.getWriter().print("Incorrecta   \n");
                listaenvio.add(robj);
            }
            
            
        }
          request.setAttribute("array", (ArrayList) listaenvio);
            //se envia a el menu principal
            RequestDispatcher a = request.getRequestDispatcher("prueba.jsp");
            a.forward(request, response);
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
      doGet(request, response);
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
