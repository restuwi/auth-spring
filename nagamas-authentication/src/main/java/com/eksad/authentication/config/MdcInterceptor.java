package com.eksad.authentication.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class MdcInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //        String ipLocal = MDC.get("ip_local");
    //        String ipPublic = MDC.get("ip_public");
    //        String requestId = MDC.get("request_id");
    //
    //        System.out.println(String.format("Request ID: %s, IP Public: %s, IP Local: %s", requestId, ipPublic, ipLocal));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }


}
