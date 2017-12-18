package com.tracy.gd.Interceptor;

import com.tracy.gd.CustomAnnotations.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.UUID;

/**
 * Created by trcay on 2017/12/18.
 */
public class TokenInterceptor extends HandlerInterceptorAdapter {

    /**
     * 弃用了网上加上自定义注解的方法， if (handler instanceof HandlerMethod) 这个判断一直抛异常
     * <p>
     * 原因目前不明，所以这个拦截器的目的只是生成一个token，并放入session中，
     * <p>
     * 然后在添加用户界面的时候通过令牌去判断是否重复提交 （最原始的方法）
     * <p>
     * Create by : linsong.wei 2017-12-18 21:02:05
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("拦截器执行preHandle,生成token,并放入session");

        String token = UUID.randomUUID().toString();
        request.getSession().setAttribute("token", token);


//        if (handler instanceof HandlerMethod) {
//            HandlerMethod handlerMethod = (HandlerMethod) handler;
//            Method method = handlerMethod.getMethod();
//            Token annotation = method.getAnnotation(Token.class);
//            if (annotation != null) {
//                boolean needSaveSession = annotation.save();
//                if (needSaveSession) {
//                    request.getSession(false).setAttribute("token", UUID.randomUUID().toString());
//                }
//                boolean needRemoveSession = annotation.remove();
//                if (needRemoveSession) {
//                    if (isRepeatSubmit(request)) {
//                        return false;
//                    }
//                    request.getSession(false).removeAttribute("token");
//                }
//
//            }
//            System.out.println("=========----========="+request.getSession().getAttribute("token"));
//            return true;
//        } else {
//            System.out.println("=========----========="+request.getSession().getAttribute("token"));
//            return super.preHandle(request, response, handler);
//        }
        return true;
    }

    private boolean isRepeatSubmit(HttpServletRequest request) {
        String serverToken = (String) request.getSession(false).getAttribute("token");
        if (serverToken == null) {
            return true;
        }
        String clinetToken = request.getParameter("token");
        if (clinetToken == null) {
            return true;
        }
        if (!serverToken.equals(clinetToken)) {
            return true;
        }
        return false;
    }
}
