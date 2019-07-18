package com.hellokoding.sso.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import java.util.Collections;
import java.util.HashMap;

@SpringBootApplication
public class WebApplication {
    @Value("${services.auth}")
    private String authService;


    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.setInitParameters(new HashMap<String, String>() {{
            put("services.auth", authService);
        }});
        registrationBean.addUrlPatterns("/protected-resource");

        registrationBean.setOrder(1);

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean RegisteredFilterOne() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new RegisteredFilterOne());
        registrationBean.setInitParameters(new HashMap<String, String>() {{
            put("some.param", "some-param");
        }});
        registrationBean.addUrlPatterns("/protected-resource");

        registrationBean.setOrder(0);

        return registrationBean;
    }




    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}

