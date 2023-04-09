package br.com.cadastrodemusicas.control;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.cadastrodemusicas.model.Usuario;

/**
 * Servlet Filter implementation class Filter
 */
@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

    /**
     * Default constructor. 
     */
    public Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req =(HttpServletRequest) request;
		HttpServletResponse resp =(HttpServletResponse) response;

		HttpSession session = req.getSession();
		Usuario usuario = null;
		usuario = (Usuario) session.getAttribute("usuario");
		String url = req.getRequestURI();
		
		if (usuario != null)
			chain.doFilter(request, response);
		else
			if (url.endsWith("registro.html")
					|| url.endsWith("index.jsp")
					|| url.endsWith("Control")
					|| url.endsWith("UsuarioLogar")
					|| url.endsWith("UsuarioAdicionar")
					|| url.endsWith("css"))
						chain.doFilter(request, response);	
			else
				resp.sendRedirect("/projeto_musica/index.jsp");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
