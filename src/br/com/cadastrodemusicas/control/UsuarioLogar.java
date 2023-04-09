package br.com.cadastrodemusicas.control;

import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.UsuarioDao;
import br.com.cadastrodemusicas.model.Usuario;

public class UsuarioLogar extends HttpServlet implements IControl 
{

	
	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String msg = "";
		String nextPage = "";
		String login = String.valueOf(request.getParameter("login"));
		String senha = String.valueOf(request.getParameter("senha"));

		UsuarioDao usuDao = new UsuarioDao();

		Usuario usuario = null;
		try 
		{
			usuario = usuDao.logar(login, senha);
		} 
		catch (SQLException e) 
		{
			msg = "Não foi possível realizar o acesso. Tente novamente!";
			nextPage = "/index.jsp";
		}
		
		if (usuario == null) 
		{
			msg = "Login ou senha inválida! Tente novamente!";
			nextPage = "/index.jsp";
		} 
		else 
		{
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			
			nextPage = "/Control?acao=MusicaListar";
		}
		
		request.setAttribute("msg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		
	}

}
