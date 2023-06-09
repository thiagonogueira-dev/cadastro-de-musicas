<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="pt-br">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Adicionar m�sica</title>
    <link rel="stylesheet" href="./css/styleMusica.css">
</head>
<body>
    <div class="login">
        <div class="first">
	        <form action="/projeto_musica/Control" method="get">
                <p class="inp-p">Cadastrar m�sica</p>
                <div class="input">
                    <label>Nome:</label>
                    <input class="validation" type="text" name="nome">
                </div>
                <div class="input">
                    <label>�lbum:</label>
                    <select name="album">
                        <c:forEach var="album" items="${albuns}">
                                <option> ${album.titulo}</option>	
                        </c:forEach>
                    </select>    
                </div>  
                <input  type="hidden" name="acao" value="MusicaAdicionar">
                <input class="btn-login" type="submit" value="Cadastrar">
            </form>
            <p class="error">${msg}</p>
        </div>
    </div>
	<a href="/projeto_musica/Control?acao=MusicaListar">Voltar</a>
</body>
</html>