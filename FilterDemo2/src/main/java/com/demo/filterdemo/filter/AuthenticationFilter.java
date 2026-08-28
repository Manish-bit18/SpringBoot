package com.demo.filterdemo.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

// ContentCacheResponseWrapper

//@Component
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest =
                (HttpServletRequest) servletRequest;

        HttpServletResponse httpServletResponse =
                (HttpServletResponse) servletResponse;

        String token = httpServletRequest.getHeader("token");

        if(token == null || !token.equals("12345")) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Authentication is required\"\n" +
                            "}"
            );
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);


    }

}