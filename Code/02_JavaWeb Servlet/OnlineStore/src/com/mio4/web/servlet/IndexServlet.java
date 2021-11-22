package com.mio4.web.servlet;

import com.mio4.domain.Product;
import com.mio4.service.IProductService;
import com.mio4.service.impl.ProductServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 跳转到首页
 */
@WebServlet(name = "IndexServlet")
public class IndexServlet extends BaseServlet {

	/**
	 * 查询最新商品和热门商品
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//TODO
		IProductService productService = new ProductServiceImpl();
		List<Product> newProductList = productService.findNew();
		List<Product> hotProductList = productService.findHot();

		//将list放入request域中
		request.setAttribute("newProductList",newProductList);
		request.setAttribute("hotProductList",hotProductList);

		return "/jsp/index.jsp";
	}
}
