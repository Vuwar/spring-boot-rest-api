package com.example.spring_boot_rest_api.config.security;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

//@Component
public class StaticKeyAuthenticationFilter implements Filter {

    @Value("${api.key}")
    private String STATIC_API_KEY;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String apiKey = httpRequest.getHeader("X-API-KEY");

        if (apiKey != null && apiKey.equals(STATIC_API_KEY)) {
            Authentication auth = new UsernamePasswordAuthenticationToken
                    ("apiUser", null, null);

            SecurityContextHolder.getContext().setAuthentication(auth);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Invalid or missing API Key2");
        }

        chain.doFilter(request, response);
    }
}
