package com.sofisticat.stockmanagerbackend.security;

import com.sofisticat.stockmanagerbackend.database.user.UserManager;
import com.sofisticat.stockmanagerbackend.security.jwt.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserManager userManager;
    private final JwtTokenFilter jwtTokenFilter;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring()
//            .mvcMatchers("/api/users/login")
//            .and()
//            .ignoring()
//            .mvcMatchers("/api/users/register");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
        http.cors().and().csrf().disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.exceptionHandling()
//                .authenticationEntryPoint((request, response, ex) -> {
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
//                }).and()
//                .authorizeRequests()
//                .antMatchers("/api/users/login")
//                .permitAll()
//                        .and()
//                .authorizeRequests()
//                .antMatchers("/api/users/register")
//                .permitAll()
//                        .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                        .and()
//                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userManager::getUserByUsername);
//    }
//
//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
