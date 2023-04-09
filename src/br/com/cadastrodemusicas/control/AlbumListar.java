package br.com.cadastrodemusicas.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.AlbumDao;
import br.com.cadastrodemusicas.model.Album;
import br.com.cadastrodemusicas.model.Usuario;

public class AlbumListar extends HttpServlet implements IControl
{

	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		AlbumDao albDao = new AlbumDao();
		List<Album> albuns = null;
		try 
		{
			albuns = albDao.listar(usuario);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(albuns.size() == 0)
		{
			String msg = "Você precisa cadastrar um Álbum primeiro.";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("index2.jsp");
			rd.forward(request, response);
			
		}
		else
		{
		request.setAttribute("albuns", albuns);
		RequestDispatcher rd = request.getRequestDispatcher("frmmusica.jsp");
		rd.forward(request, response);
		}
	}
	
}
