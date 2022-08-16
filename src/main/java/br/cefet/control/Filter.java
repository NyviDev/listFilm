package br.cefet.control;

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

import br.cefet.model.Usuario;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {

	public Filter() {
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

		// Pegar a sseion e o cliente
		HttpSession session = req.getSession();
		Usuario usuario = null;
		usuario = (Usuario) session.getAttribute("usuario");
		String url = req.getRequestURI();
		System.out.println(url);
		System.out.println("Usuario: " + usuario);

		if (usuario != null)
			chain.doFilter(request, response);
		else if (url.endsWith("registro.html") || url.endsWith("Control") || url.endsWith("login.jsp")
				|| url.endsWith("UsuarioAdicionar") || url.endsWith("UsuarioLogar"))
			chain.doFilter(request, response);
		else
			resp.sendRedirect("/listfilm/login.jsp");

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

};