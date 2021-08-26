package Beans;

public class Login {
    private String login;
    private String senha;
    public String status;

    public boolean validarLogin( String login, String senha, String status){

        if(login.equalsIgnoreCase("admin") && senha.equalsIgnoreCase("admin")){
            return true;
        } else{
            return false;
        }
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(){
        this.status = status;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha(){
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
