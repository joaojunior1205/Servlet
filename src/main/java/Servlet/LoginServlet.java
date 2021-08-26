package Servlet;

import Beans.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login Login = new Login();

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if (Login.validarLogin(login, senha)){ // Acesso liberado
            RequestDispatcher dispatcher = request.getRequestDispatcher("AcessoLiberado.jsp");
            dispatcher.forward(request, response);
        } else{
            // Acesso negado
            RequestDispatcher dispatcher = request.getRequestDispatcher("AcessoRecusado.jsp");
            dispatcher.forward(request, response);
        }
    }
}
