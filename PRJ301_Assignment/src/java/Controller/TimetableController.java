/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import model.Lecture;
import model.Session;
import model.TimeSlot;
import util.DateTimeHelper;

/**
 *
 * @author Admin
 */
public class TimetableController extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int lid = Integer.parseInt(request.getParameter("lid"));
        String raw_from = request.getParameter("from");
        String raw_to = request.getParameter("to");
        java.sql.Date from = null;
        java.sql.Date to = null;
        if(raw_from ==null || raw_from.length() ==0)
        {
            Date today = new Date();
            int todayOfWeek = DateTimeHelper.getDayofWeek(today);
            Date e_from = DateTimeHelper.addDays(today, 2 - todayOfWeek);
            Date e_to = DateTimeHelper.addDays(today, 8-todayOfWeek);
            from = DateTimeHelper.toDateSql(e_from);
            to = DateTimeHelper.toDateSql(e_to);
        }
        else
        {
            from = java.sql.Date.valueOf(raw_from);
            to = java.sql.Date.valueOf(raw_to);
        }
        
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("dates", DateTimeHelper.getDateList(from, to));
        
        TimeSlotDBContext slotDB = new TimeSlotDBContext();
        ArrayList<TimeSlot> slots = slotDB.list();
        request.setAttribute("slots", slots);
        
        SessionDBContext sesDB = new SessionDBContext();
        ArrayList<Session> sessions = sesDB.filter(lid, from, to);
        request.setAttribute("sessions", sessions);
        
        LecturerDBContext lecDB = new LecturerDBContext();
        Lecture lecturer = lecDB.get(lid);
        request.setAttribute("lecturer", lecturer);
        
        request.getRequestDispatcher("Timetable.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    processRequest(req,resp);
    }
    
}
