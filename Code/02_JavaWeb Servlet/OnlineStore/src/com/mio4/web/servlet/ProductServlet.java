package com.mio4.web.servlet;

import com.mio4.domain.PageBean;
import com.mio4.domain.Product;
import com.mio4.service.IProductService;
import com.mio4.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet")
public class ProductServlet extends BaseServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * 通过id查询单个商品
	 * @param request
	 * @param response
	 * @return
	 */
	public String getById(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//System.out.println("product service");
		//1.获取商品的id
		String pid = request.getParameter("pid");
		//2.调用Service
		IProductService productService = new ProductServiceImpl();
		Product product =  productService.getByPid(pid);
		//3.将结果放入request域中
		request.setAttribute("product",product);
		//4.请求转发
		return "/jsp/product_info.jsp";
	}

	public String findByPage(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//System.out.println("find by page");
		//1.获取当前页
		String cid = request.getParameter("cid");
		int currPage = Integer.parseInt(request.getParameter("currPage"));
		int pageSize = 12;
		//2.调用Service，返回pageBean
		IProductService productService = new ProductServiceImpl();
		PageBean<Product> pageBean = productService.findByPage(currPage,pageSize,cid);
		//3.将pageBean放在request
		request.setAttribute("pageBean",pageBean);
		return "/jsp/product_list.jsp";
	}
}
