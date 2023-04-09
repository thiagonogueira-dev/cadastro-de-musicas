package br.com.cadastrodemusicas.control;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.MusicaDao;
import br.com.cadastrodemusicas.model.Musica;
import br.com.cadastrodemusicas.model.Usuario;

public class MusicaListar extends HttpServlet implements IControl
{
	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		String nextPage = "/index2.jsp";
		
		HttpSession session = req.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		MusicaDao mscDao = new MusicaDao();
		List<Musica> musicas = null;
		try 
		{
			musicas = mscDao.listar(usuario);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(musicas.size() == 0)
		{
			req.setAttribute("msg2", "Nenhuma música cadastrada");
		}
		else
		{
			req.setAttribute("musicas", musicas);
			req.setAttribute("msc", "Música");
			req.setAttribute("alb", "Álbum");
			req.setAttribute("art", "Artista");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher(nextPage);
		rd.forward(req, res);
	}
}
