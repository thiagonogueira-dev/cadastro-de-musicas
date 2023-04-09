<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Home</title>
		<link rel="stylesheet" href="./css/styleIndex2.css">
	</head>
<body>
    <div class="main">
    	<div class="header">
	        <h1>Seja bem-vindo(a), ${usuario.nome}</h1>
	        <a href="Control?acao=UsuarioSair">Sair</a>
	    </div>
         
        <div class="options">
            <div class="options2">
                <p>+</p>
                <a href ="frmartista.jsp">Cadastrar artista</a>
            </div>
            <div class="options2">
                <p>+</p>
                <a href="/projeto_musica/Control?acao=ArtistaListar">Cadastrar álbum</a>
            </div>
            <div class="options2">
                <p>+</p>
                <a href ="/projeto_musica/Control?acao=AlbumListar">Cadastrar música</a>
            </div>
        </div>
        <p class="msg">${msg}</p>
        <hr>
        
        <p>Músicas cadastradas:</p>
        
        <table>
            <tr><th>${msc}</th> <th>${alb}</th> <th>${art}</th></tr>
            <c:forEach var="musica" items="${musicas}">
                    <tr>
                    <td>${musica.nome}</td>
                    <td>${musica.album.titulo}</td>
                    <td>${musica.artista.nome}</td>
                    <td><a href="Control?acao=MusicaEditar&id=${musica.id}">Editar</a></td>
                    <td><a href="Control?acao=MusicaExcluir&id=${musica.id}">Excluir</a></td>
                    </tr>	
            </c:forEach>
        </table>
        <p>${msg2}</p>
    </div>
</body>
</html>
