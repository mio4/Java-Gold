package com.example.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigDemo1
 */
@WebServlet("/ServletConfigDemo1")
public class ServletConfigDemo1 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private ServletConfig config;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConfigDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException{
    	//当调用init()方法时，tomcat会将ServletConfig传递给Servlet
    	this.config = config;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramVal = this.config.getInitParameter("name");
		response.getWriter().print(paramVal);
		response.getWriter().print("what??");
		response.getWriter().print("<hr/>");
		Enumeration<String> e = config.getInitParameterNames();
		while(e.hasMoreElements()){
			String name = e.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name + "=" + value + "<br/>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
