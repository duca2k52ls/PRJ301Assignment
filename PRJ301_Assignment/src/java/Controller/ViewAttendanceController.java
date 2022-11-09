/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dal.SessionDBContext;
import dal.SubDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import model.Session;
import model.Subject;

/**
 *
 * @author Admin
 */
public class ViewAttendanceController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int stdid = Integer.parseInt(request.getParameter("stdid"));
        int subid = Integer.parseInt(request.getParameter("subid"));
        String sem  = request.getParameter("sem");
        String year = request.getParameter("year");
        
        SessionDBContext sdb = new SessionDBContext();
        ArrayList<Session> ses = sdb.getAttStatus(stdid, subid, sem, year);
        
        SubDBContext sub = new SubDBContext();
        ArrayList<Subject> subject = sub.list(stdid);
        request.setAttribute("subject", subject);
        
        request.setAttribute("sessions", ses);
        request.getRequestDispatcher("ViewAttendance.jsp").forward(request, response);
        
    }
}
