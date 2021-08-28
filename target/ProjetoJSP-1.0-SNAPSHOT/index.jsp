<%@ page import="Beans.Login" %><%--<jsp:useBean id="" class="Beans.Login" scope="page"/>--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="style/login.css"/>
</head>
<body>
    <div class="form-login">
        <form action="LoginServlet" method="post">
            <span>Login</span>
            <br/>
            <input type="text" id="login" name="login" placeholder="Usuário">
            <br/><br/>
            <span>Senha</span>
            <br/>
            <input type="password" id="senha" name="senha" placeholder="Senha">
            <br/>
            <input type="submit" value="Entrar">
            <br/><br/>
            <a href="#" class="link">Registrar</a>
            <br/>
            <a href="#" class="link">Esqueci a senha</a>
            <br/><br/>
            <c:if test="${!empty acessoNegado}">
            <p>${requestScope.acessoNegado}</p>
            </c:if>
        </form>
    </div>

</body>
</html>