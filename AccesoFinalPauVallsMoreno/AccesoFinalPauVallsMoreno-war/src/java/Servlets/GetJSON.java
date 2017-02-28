/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
import Entidades.Questions;
import EntidadesS.QuestionsFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pauva
 */
public class GetJSON extends HttpServlet {

    @EJB
    private QuestionsFacade questionsFacade;


     private final  Gson gson;
     
     
       public GetJSON() {
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }
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
          PrintWriter out = response.getWriter();
        
        response.setContentType("application/json");
        out.print(gson.toJson(randomQuestions()));
    
        
    }
    private ArrayList<Questions> randomQuestions(){
      ArrayList<Questions> randomQuestions = new ArrayList<Questions>();
      List<Questions> cq = questionsFacade.findAllText();
      Collections.shuffle(cq);
      if(cq.get(0)!=null) randomQuestions.add(cq.get(0));
      if(cq.get(1)!=null) randomQuestions.add(cq.get(1));
      for(int i=2;i!=6;i++){
      cq = questionsFacade.findAllwOptions(i);
      Collections.shuffle(cq);
      if(cq.get(0)!=null) randomQuestions.add(cq.get(0));
      if(cq.get(1)!=null) randomQuestions.add(cq.get(1));    
      }
      Collections.shuffle(randomQuestions);
      return randomQuestions;
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
            throws ServletException, IOException { processRequest(request, response);
        
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
