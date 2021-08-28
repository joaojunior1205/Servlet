<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Entrar</title>
    <style><%@include file="Styles/login.css"%></style>
</head>
<body>
    <div class="form-login">
        <form action="LoginServlet" method="post">
            <span>Usuário</span>
            <br/>
            <input type="text" id="login" name="login" placeholder="Usuário">
            <br/>
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