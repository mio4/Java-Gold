package com.mio4.web.servlet;

import com.mio4.domain.Category;
import com.mio4.service.ICategoryService;
import com.mio4.service.impl.CategoryServiceImpl;
import com.mio4.utils.JsonUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends BaseServlet{

	/**
	 * 查询所有的分类信息
	 * @return
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//0.设置编码
		response.setContentType("text/html;charset=UTF-8");

		//System.out.println("index");
		//1.调用categoryService 查询商品
		ICategoryService categoryService = new CategoryServiceImpl();
		List<Category> clist = categoryService.findAll();

		//从数据库查询商品，放入request域中
		//request.setAttribute("clist",clist);

		String json = JsonUtil.list2json(clist);
		PrintWriter pw = response.getWriter();
		pw.write(json);

		return null;
	}
}
