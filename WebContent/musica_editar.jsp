<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    <%@	taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>Editar música</title>
		<link rel="stylesheet" href="./css/styleAlbum.css">
	</head>
	<body>
		<div class="login">
			<div class="first">
				<p>Nome atual: ${musica.nome}</p>
				<form action="/projeto_musica/Control" method="get">
		                <div class="input">
		                    <label>Novo nome:</label>
		                    <input class="validation" type="text" name="nome">
		                </div>
						<input  type="hidden" name="acao" value="MusicaUpdate">
		                <input class="btn-login" type="submit" value="Alterar">
		        </form>
		    </div>
	    </div>
	</body>
</html>