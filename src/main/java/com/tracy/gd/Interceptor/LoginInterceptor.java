package com.tracy.gd.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by trcay on 2018/4/10.
 */

public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     *  Create by: linsong.wei 2018-04-10 14:08:52
     * 当用户未登录的时候，拦截请求，跳转到登陆界面。
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String userName = String.valueOf(request.getSession().getAttribute("userName"));

        if (userName=="null") {
            request.getRequestDispatcher("/FinalIndex.jsp").forward(request, response);
            return false;
        }

        return true;
    }
}
