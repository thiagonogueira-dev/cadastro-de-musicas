package br.com.cadastrodemusicas.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.MusicaDao;
import br.com.cadastrodemusicas.model.Musica;

public class MusicaEditar extends HttpServlet implements IControl 
{

	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
	int id = Integer.valueOf(req.getParameter("id"));
		
		MusicaDao mscDao = new MusicaDao();
		Musica musica = mscDao.buscar(id);
		req.setAttribute("musica", musica);
		
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		
		RequestDispatcher rd = req.getRequestDispatcher("musica_editar.jsp");
		rd.forward(req, res);
	}
	
}
