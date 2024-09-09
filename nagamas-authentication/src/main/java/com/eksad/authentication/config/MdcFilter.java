package com.eksad.authentication.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class MdcFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String ipPublic = request.getHeader("X-Forwarded-For");
        if (ipPublic == null) {
            ipPublic = request.getRemoteAddr();
        }
        String ipLocal = request.getLocalAddr();
        String requestId = java.util.UUID.randomUUID().toString();

        // Menambahkan informasi ke MDC
        MDC.put("ip_public", ipPublic);
        MDC.put("ip_local", ipLocal);
        MDC.put("request_id", requestId);

        filterChain.doFilter(request, response);
    }
}
