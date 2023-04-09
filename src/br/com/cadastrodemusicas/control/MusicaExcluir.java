package br.com.cadastrodemusicas.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.cadastrodemusicas.dao.MusicaDao;

public class MusicaExcluir extends HttpServlet implements IControl 
{
	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		int id = Integer.valueOf(req.getParameter("id"));
		
		MusicaDao mscDao = new MusicaDao();
		mscDao.excluir(id);
		
		req.setAttribute("msg", "Música excluída com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("Control?acao=MusicaListar");
		rd.forward(req, res);
	}

}
