package com.demo.filterdemo.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component is not required as this is provided by Springboot
public class SpringDemoFilter extends OncePerRequestFilter {

    //SpringBoot Filter - The only major difference between the springboot filter and Servlet filter is
    // In Servlet we have to typecast the ServletRequest to HttpServletRequest

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String uri = request.getRequestURI();        //Built-in Method for the parameter that should not be Filtered

        return !uri.startsWith("/api/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        filterChain.doFilter(request, response);

    }
}