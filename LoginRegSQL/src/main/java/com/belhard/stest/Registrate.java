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

@WebServlet("/reg")
public class Registrate  extends HttpServlet {
    UserBase base;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        if((UserBase)session.getAttribute("userBase")==null){
            base=new UserBase();
            System.out.println("база создана в регистрации");
        }
        else{
            base=(UserBase) session.getAttribute("userBase");
            System.out.println("база найдена в регистрации");
        }
         String name=req.getParameter("name");
            String password=req.getParameter("password");
            String login=req.getParameter("login");
            boolean admin=true;
            if(UserBase.haveUser(login)){
                session.setAttribute("userBase",base);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/Registation.jsp");
                requestDispatcher.forward(req, resp);
                System.out.println("Такой пользователь уже есть");
            }
            else{
       switch ((String) req.getParameter("admin-check")){
                case "userrole" :
                    admin=false;
                    break;
                case "adminrole":
                    admin=true;
                    break;
            }
                UserBase.AddUser(name,login,password,admin);
                System.out.println("Создан новый пользователь");
              // System.out.println("Создан новый пользователь "+ UserBase.getUser(login,password).getLogin());
                session.setAttribute("userBase",base);
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
                requestDispatcher.forward(req, resp);}
    }
}
