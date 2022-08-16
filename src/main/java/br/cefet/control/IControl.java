package br.cefet.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IControl {
	
	public void executa(HttpServletRequest req,
		HttpServletResponse res) throws Exception;
	
}


