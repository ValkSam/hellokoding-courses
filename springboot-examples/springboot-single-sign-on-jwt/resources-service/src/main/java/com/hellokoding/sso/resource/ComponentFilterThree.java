package com.hellokoding.sso.resource;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(3)
public class ComponentFilterThree implements Filter {

    @Override
    public void doFilter(ServletRequest httpServletRequest, ServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(">> ComponentFilterThree");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }


}
