package com.example.praktika_jwt_token.security;

import com.example.praktika_jwt_token.entity.CustomUserDetails;
import com.example.praktika_jwt_token.service.CustomUserDetailsService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static io.jsonwebtoken.lang.Strings.hasText;

@Component
@Log
public class JwtFilter extends GenericFilter {
    private static  final  String AUTHORIZATION = "Authorization";
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService userDetService;
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        {
            if (token != null && jwtProvider.validateToken(token)) {
                System.out.println("if");
                String email = jwtProvider.getLoginFromToken(token);
                System.out.println(email);
                CustomUserDetails customUserDetails = (CustomUserDetails) userDetService.loadUserByUsername(email);
                System.out.println(customUserDetails);
                UsernamePasswordAuthenticationToken aut =
                        new UsernamePasswordAuthenticationToken(customUserDetails, customUserDetails, customUserDetails.getAuthorities());
                System.out.println(aut);
                SecurityContextHolder.getContext().setAuthentication(aut);
            }
            System.out.println("end");
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    public String getTokenFromRequest(HttpServletRequest request){
        String bear = request.getHeader(AUTHORIZATION);
        if(hasText(bear)&&bear.startsWith("Bearer ")){
            return bear.substring(7);
        }
        return  null;


    }
}
