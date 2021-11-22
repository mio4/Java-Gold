package com.mio4.interceptor;

import com.mio4.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorizationInterceptor implements HandlerInterceptor {
    private static final String[] IGNORE_URL = {"/loginForm","/login"};

    //在Controller之前调用
    //如果返回值为false，则整个请求结束
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("Authorization Interceptor preHandle~");
        boolean is_login = false; //用户是否登录
        String servlet_path = request.getServletPath();
        //System.out.println("servlet_path " + servlet_path);
        //判断请求是否需要被拦截
        for(String s: IGNORE_URL){
            if(servlet_path.contains(s)){
                is_login = true;
                break;
            }
        }
        //判断用户是否登录
        if(!is_login){
            User user = (User) request.getSession().getAttribute("user");
            if(user == null){
                System.out.println("Authorization Interceptor 拦截请求");
                request.setAttribute("message","请登录后访问网站");
                //request.getRequestDispatcher("/loginForm").forward(request,response);
                //request.getRequestDispatcher("index.jsp").forward(request,response);
                request.getRequestDispatcher("content/loginForm.jsp").forward(request,response);
            } else{
                System.out.println("Authorization Interceptor 放行请求");
                is_login = true;
            }
        }
        return is_login;
    }

    //当Controller方法调用之后执行
    //只有当前Interceptor的preHandle返回为true时才执行
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Authorization Interceptor postHandle~");
    }

    //请求完成之后执行，用于清理资源
    //只有当前Interceptor的preHandle返回为true时才执行
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("Authorization Interceptor afterCompletion~");
    }
}
