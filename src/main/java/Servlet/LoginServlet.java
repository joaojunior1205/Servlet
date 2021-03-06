package Servlet;

import Beans.Login;
import Dao.DaoLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private DaoLogin DaoLogin = new DaoLogin();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login Login = new Login();

        try{

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        String acessoNegado = "Usuário e/ou senha inválidos";

        if (DaoLogin.validarLogin(login, senha)){
            // Acesso liberado
            RequestDispatcher dispatcher = request.getRequestDispatcher("AcessoLiberado.jsp");
            dispatcher.forward(request, response);
        } else{
            // Acesso negado
            request.setAttribute("acessoNegado", acessoNegado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
