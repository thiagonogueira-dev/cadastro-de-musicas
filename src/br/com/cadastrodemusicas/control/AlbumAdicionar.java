package br.com.cadastrodemusicas.control;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.AlbumDao;
import br.com.cadastrodemusicas.dao.ArtistaDao;
import br.com.cadastrodemusicas.model.Album;
import br.com.cadastrodemusicas.model.Artista;
import br.com.cadastrodemusicas.model.Usuario;

public class AlbumAdicionar extends HttpServlet implements IControl 
{

	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String titulo = null;
		
		titulo = String.valueOf(request.getParameter("titulo"));
		Album album = new Album();
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		String nomeArtista = String.valueOf(request.getParameter("artista"));
		Artista artista = new Artista();
		ArtistaDao artDao = new ArtistaDao();
		
		try 
		{	
			artista = artDao.buscar(nomeArtista, usuario.getId());
			album.setArtista(artista);
			album.setTitulo(titulo);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		AlbumDao albDao = new AlbumDao();
		try 
		{
			albDao.add(album);
			request.setAttribute("msg", "Álbum cadastrado com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("Control?acao=ArtistaListar");
			rd.forward(request, response);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
