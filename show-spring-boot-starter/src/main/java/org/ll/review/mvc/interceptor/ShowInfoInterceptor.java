package org.ll.review.mvc.interceptor;

import org.ll.review.mvc.prop.ShowProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowInfoInterceptor  implements HandlerInterceptor {


    @Autowired
    private ShowProperties showProperties;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(showProperties.isShow()){
            //拦截执行逻辑
            if(StringUtils.hasText(showProperties.getInfo())){
                System.out.println(showProperties.getInfo());
            }else{
                System.out.println("Hello，from demo start yes....");
            }
        }
        return true;
    }
}
