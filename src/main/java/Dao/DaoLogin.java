package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Connection.SingleConnection;
public class DaoLogin {
    private Connection connection;
    public DaoLogin(){
        connection = SingleConnection.getConnection();
    }

    public boolean validarLogin(String login, String senha) throws Exception{
        String sql = "SELECT usuario.login_usuario, usuario.senha FROM tabelas.usuario WHERE login_usuario = '" + login + "' AND senha = '" + senha + "'";
        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet result = stmt.executeQuery();

        if (result.next()){
            // Usuário correto.
            return true;
        }else{
            // Usuário incorreto.
            return false;
        }
    }

}
