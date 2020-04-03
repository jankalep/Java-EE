package com.belhard.stest;

import repo.UserBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class MainServlet extends HttpServlet {
    UserBase base;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");
        String login = req.getParameter("login");
        ServletContext servletContext = getServletContext();
        HttpSession session = req.getSession();
        if (session.getAttribute("userBase") == null) {
            base = new UserBase();
            System.out.println("база не найдена в логине");
        } else {
            base = (UserBase) session.getAttribute("userBase");
            System.out.println("база найдена в логине");
        }
        session.setAttribute("userBase", base);
        if (UserBase.checkUser(login, password)) {
            String hellouser = UserBase.getUser(login, password).getName();
            session.setAttribute("name", hellouser);
            System.out.println("Мы увидим пользователя: " + UserBase.getUser(login, password).getName());
            if (UserBase.getUser(login, password).isRole()) {
                System.out.println("Пользователь является админом");
                session.setAttribute("admin", true);
                session.setAttribute("base", UserBase.getAllUsers());
            }
            else {
                session.setAttribute("admin", false);
                session.setAttribute("base", null);
            }
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/Hello.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
            System.out.println("Пользователь не найден");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

