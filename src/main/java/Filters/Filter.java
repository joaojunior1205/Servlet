package Filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import Connection.SingleConnection;

import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebFilter(urlPatterns={"/*"})
public class Filter implements javax.servlet.Filter{

    private static Connection connection;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        SingleConnection.getConnection();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        try {
            chain.doFilter(request, response);

            connection.commit();

        }catch (Exception e){
            try{
                connection.rollback();

            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }

}
