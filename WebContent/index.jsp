<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="./css/styleIndex.css">
</head>
<body>
    <div class="login">
        <div class="first">
            <p class="login-p">Login</p>
            <form action="/projeto_musica/Control" method="get">
                <div class="input">
                    <label class="in1">Login:</label>
                    <input class="validation" type="text" name="login">
                </div>
                <div class="input">
                    <label>Senha:</label>
                    <input  class="validation" type="password" name="senha">
                </div>
                <input  type="hidden" name="acao" value="UsuarioLogar">
                <input  class="btn-login" type="submit" value="Entrar">
            </form>
        	<p class="error">${msg}</p>
        </div>
        <div class="register">
            <a href="registro.html">Registrar-se</a>
        </div>
    </div>
</body>
</html>

