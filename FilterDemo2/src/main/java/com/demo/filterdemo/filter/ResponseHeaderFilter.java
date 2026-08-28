package com.demo.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

//@Component
public class ResponseHeaderFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse;

        String requestId = UUID.randomUUID().toString();

        httpServletResponse.setHeader("x-request-id" , requestId);

        filterChain.doFilter(servletRequest, servletResponse);
    }
}