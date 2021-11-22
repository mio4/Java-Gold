package com.mio4.interceptor;

import com.mio4.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//尝试第二种拦截方式
public class AuthorizationInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        boolean flag = false; //用户是否登录
        if(user == null){
            System.out.println("用户没有登录");
            request.setAttribute("message","请登录后访问网站");
            request.getRequestDispatcher("content/loginForm.jsp").forward(request,response);
        }else{
            System.out.println("用户已经登录");
            flag = true;
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
