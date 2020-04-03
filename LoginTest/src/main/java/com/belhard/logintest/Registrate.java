package com.belhard.logintest;

import javax.jws.soap.SOAPBinding;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Reg")
public class Registrate  extends HttpServlet {
    UserBase base;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();


        if((UserBase)session.getAttribute("userbase")==null){
            base=new UserBase();
            System.out.println("база создана в регистрации");

        }
        else{
            base=(UserBase) session.getAttribute("userbase");
            System.out.println("база найдена в регистрации");
        }
         String name=req.getParameter("name");
            String password=req.getParameter("password");
            String login=req.getParameter("login");
            

            if(UserBase.haveUser(login)){
                session.setAttribute("userbase",base);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Registation.jsp");
                requestDispatcher.forward(req, resp);
            }
            UserBase.AddUser(name,login,password);
            System.out.println("Создан новый пользователь "+ UserBase.getUser(login,password).getLogin());

            session.setAttribute("userbase",base);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);

               
            }









    }

