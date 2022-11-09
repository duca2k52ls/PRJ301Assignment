/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import dal.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.Account;
import model.Role;
import model.Student;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserDAO userDao = new UserDAO();
        if (userDao.checkAccount(username, password)) {
            Account accnor = userDao.getAccount(username);
            if(accnor.getRole().isRole() == true) {
                Account acc = userDao.getAccountStu(username);
                HttpSession session = req.getSession();
                session.setAttribute("account", acc);
                resp.sendRedirect("HomePage.jsp");
            } else {
                Account acc = userDao.getAccountLec(username);
                HttpSession session = req.getSession();
                session.setAttribute("account", acc);
                resp.sendRedirect("HomePage.jsp");
            }
        } else {
            req.setAttribute("msg", "Username or password is incorrect");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("login.jsp");
    }

}
