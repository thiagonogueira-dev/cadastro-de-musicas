package br.com.cadastrodemusicas.control;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.dao.MusicaDao;

public class MusicaUpdate extends HttpServlet implements IControl
{
	
	private static final long serialVersionUID = 1L;

	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception 
	{
		HttpSession session = req.getSession();
		int id = (int) session.getAttribute("id");
		
		String nome = String.valueOf(req.getParameter("nome"));
		MusicaDao mscDao = new MusicaDao();
		mscDao.alterar(id, nome);
		
		req.setAttribute("msg", "Música editada com sucesso!");
		RequestDispatcher rd = req.getRequestDispatcher("Control?acao=MusicaListar");
		rd.forward(req, res);
	}

}
