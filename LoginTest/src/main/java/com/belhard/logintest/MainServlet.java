package com.belhard.logintest;

import com.sun.webkit.WebPageClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MainServlet extends HttpServlet {
    UserBase base;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password=req.getParameter("password");
        String login=req.getParameter("login");
        ServletContext servletContext = getServletContext();
        HttpSession session=req.getSession();
        if((UserBase)session.getAttribute("userbase")==null){
            base=new UserBase();
            System.out.println("база не найдена в логине");

        }
        else{

            base=(UserBase) session.getAttribute("userbase");
            System.out.println("база найдена в логине");
        }

       //ArrayList<UserAccount> users= UserBase.getAllUsers();
       //System.out.println("Users have size "+users.size());
       // for(UserAccount person : users){

         //   System.out.println(person.getLogin());
        //}
        session.setAttribute("userbase",base);
          if (UserBase.checkUser(login, password)) {
             String hellouser=(String) UserBase.getUser(login,password).getName();

               session.setAttribute("name", hellouser);

               System.out.println("Мы увидим пользователя: "+UserBase.getUser(login,password).getName());

              RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/Hello.jsp");
              requestDispatcher.forward(req, resp);
          } else {
System.out.println("Пользователь не найден");
              RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
              requestDispatcher.forward(req, resp);
//              resp.setContentType("text/html");
//              PrintWriter writer = resp.getWriter();
//              writer.println("<h2>Maybe something wrong:(<h2>");
          }

    }
}

