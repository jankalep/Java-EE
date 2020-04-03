package com.belhard.stest;

import repo.UserBase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/hello-servlet")
public class HelloUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        if(session.getAttribute("userBase")!=null) {
            System.out.println("база пристутсвует");
            int id = Integer.parseInt(request.getParameter("id"));
            UserBase.deleteUser(id);
            System.out.println("пользователь удалён");
            session.setAttribute("base", UserBase.getAllUsers());
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Hello.jsp");
            requestDispatcher.forward(request, response);
        }
        else{System.out.println("база отсутсвует");}
    }
}
