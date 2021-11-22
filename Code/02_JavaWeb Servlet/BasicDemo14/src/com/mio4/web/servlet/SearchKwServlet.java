package com.mio4.web.servlet;

import com.mio4.web.service.KeywordService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 模拟搜索引擎
 */

@WebServlet(name = "SearchKwServlet")
public class SearchKwServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post from the ajax");
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		System.out.println("get from the ajax");

		//1.获取参数
		String keyword = request.getParameter("kw");
		//System.out.println(keyword);

		//2.调用Service
		List<Object> list = null;

		try{
			list = new KeywordService().findKeywordByAja(keyword);
		} catch(Exception e){
			e.printStackTrace();
		}

		//将数据写回
		if(list != null && list.size() > 0){
			String s = list.toString();
			s = s.substring(1,s.length()-1);
			System.out.println(s);
			pw.write(s);
		}

	}
}
