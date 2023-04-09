package br.com.cadastrodemusicas.control;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.AlbumDao;
import br.com.cadastrodemusicas.dao.MusicaDao;
import br.com.cadastrodemusicas.model.Musica;
import br.com.cadastrodemusicas.model.Usuario;

public class MusicaAdicionar extends HttpServlet implements IControl 
{
	
	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		String nome = null;
		
		nome = String.valueOf(request.getParameter("nome"));
		Musica musica = new Musica();
		musica.setNome(nome);
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		String titulo = String.valueOf(request.getParameter("album"));
		AlbumDao albDao = new AlbumDao();
		
		try 
		{	
			musica.setAlbum(albDao.buscar(titulo, usuario.getId()));
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		MusicaDao mscDao = new MusicaDao();
		try 
		{
			mscDao.add(musica);
			request.setAttribute("msg", "Música cadastrada com sucesso!");
			RequestDispatcher rd = request.getRequestDispatcher("Control?acao=AlbumListar");
			rd.forward(request, response);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
