package com.sofisticat.stockmanagerbackend.security.jwt;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtTokenConfiguration {


    @Bean
    public FilterRegistrationBean<JwtTokenFilter> registrationBean(JwtTokenFilter filter) {
        FilterRegistrationBean<JwtTokenFilter> registrationBean = new FilterRegistrationBean<>(filter);
        registrationBean.setEnabled(false);


        return registrationBean;
    }

}
