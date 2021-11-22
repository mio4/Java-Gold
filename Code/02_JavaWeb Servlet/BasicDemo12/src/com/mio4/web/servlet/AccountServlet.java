package com.mio4.web.servlet;

import com.mio4.web.service.AccountService;
import com.mio4.web.service.AccountService4DB;
import com.mio4.web.service.AccountService4tl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * 模拟银行转账
 */
@WebServlet(name = "AccountServlet")
public class AccountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.设置编码
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();

		//1.获取参数
		String fromUser = request.getParameter("fromUser");
		String toUser = request.getParameter("toUser");
		String money = request.getParameter("money");

		//2.调用AccountService
		try {
			//new AccountService().account(fromUser,toUser,money);
			//new AccountService4tl().account(fromUser,toUser,money);
			new AccountService4DB().account(fromUser,toUser,money);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.打印信息
		pw.write("转账成功");
	}
}
