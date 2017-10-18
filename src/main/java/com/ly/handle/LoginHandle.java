package com.ly.handle;

import com.ly.annotation.LoginNotRequired;
import com.ly.exception.UnLogin;
import com.ly.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by ly on 2017/10/18 21:11
 */
public class LoginHandle extends HandlerInterceptorAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String VOID = "{\"result\": \"OK\"}";

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        } else {
            HandlerMethod method = (HandlerMethod) handler;
            
            if (method.getBeanType().isAnnotationPresent(LoginNotRequired.class)) {
                return true;
            } else if (method.getMethod().isAnnotationPresent(LoginNotRequired.class)) {
                return true;
            } else {
                HttpSession session = request.getSession(true);

                User user = (User) session.getAttribute("user");
                if (user != null) {
                    logger.info(user.toString());
                    return true;
                } else {
                    throw new UnLogin();
                }
            }
        }
        
        
    }
}
