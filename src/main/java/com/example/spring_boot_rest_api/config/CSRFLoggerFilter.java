package com.example.spring_boot_rest_api.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.function.Supplier;

@Component
public class CSRFLoggerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        Object crsftAttr = request.getAttribute("_csrf");
        if (crsftAttr instanceof Supplier) {
            @SuppressWarnings("unchecked")
            Supplier<CsrfToken> csrfSupplier = (Supplier<CsrfToken>) crsftAttr;
            CsrfToken csrfToken = csrfSupplier.get();
            System.out.println("CSRF Token: " + csrfToken.getToken());
        } else if (crsftAttr instanceof CsrfToken crsfToken) {
            System.out.println("CSRF Token: " + crsfToken.getToken());
        }

        filterChain.doFilter(request, response);
    }
}
