package br.com.cadastrodemusicas.control;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrodemusicas.dao.UsuarioDao;
import br.com.cadastrodemusicas.model.Usuario;

public class UsuarioAdicionar extends HttpServlet implements IControl
{
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		String nome = null;
		String login = null;
		String senha = null;
		
		nome = String.valueOf(req.getParameter("nome"));
		login = String.valueOf(req.getParameter("login"));
		senha = String.valueOf(req.getParameter("senha"));
	
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		UsuarioDao uDao = new UsuarioDao();
		try {
			uDao.add(usuario);
			req.setAttribute("msg", "Usuário cadastrado com sucesso!");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			req.setAttribute("msg", "Erro no cadastro!");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, res);
	}

}
