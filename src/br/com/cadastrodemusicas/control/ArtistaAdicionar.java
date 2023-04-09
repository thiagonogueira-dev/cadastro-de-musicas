package br.com.cadastrodemusicas.control;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.ArtistaDao;
import br.com.cadastrodemusicas.model.Artista;
import br.com.cadastrodemusicas.model.Usuario;

public class ArtistaAdicionar extends HttpServlet implements IControl 
{

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String nome = null;
		
		nome = String.valueOf(request.getParameter("nome"));
		Artista artista = new Artista();
		artista.setNome(nome);
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		artista.setUsuario(usuario);
		
		ArtistaDao aDao = new ArtistaDao();
		try 
		{
			aDao.add(artista);
			request.setAttribute("msg", "Artista cadastrado com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("frmartista.jsp");
			rd.forward(request, response);
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
