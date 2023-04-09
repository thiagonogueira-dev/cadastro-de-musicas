package br.com.cadastrodemusicas.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.ArtistaDao;
import br.com.cadastrodemusicas.model.Artista;
import br.com.cadastrodemusicas.model.Usuario;

public class ArtistaListar extends HttpServlet implements IControl
{

	private static final long serialVersionUID = 1L;

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		ArtistaDao artistaDao = new ArtistaDao();
		List<Artista> artistas = null;
		try 
		{
			artistas = artistaDao.listar(usuario);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(artistas.size() == 0)
		{
			String msg = "Você precisa cadastrar um artista primeiro.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
			rd.forward(request, response);
			
		}
		else
		{
		request.setAttribute("artistas", artistas);
		RequestDispatcher rd = request.getRequestDispatcher("frmalbum.jsp");
		rd.forward(request, response);
		}
	}

}
