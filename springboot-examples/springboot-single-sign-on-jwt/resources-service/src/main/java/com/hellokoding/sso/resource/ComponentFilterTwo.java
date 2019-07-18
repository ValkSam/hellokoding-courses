package com.hellokoding.sso.resource;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class ComponentFilterTwo implements Filter {

    @Override
    public void doFilter(ServletRequest httpServletRequest, ServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(">> ComponentFilterTwo");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
