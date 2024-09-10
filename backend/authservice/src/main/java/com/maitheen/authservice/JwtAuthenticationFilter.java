package com.maitheen.authservice;  // Make sure this matches the package structure of your project


import java.io.IOException;

import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Your JWT authentication logic here

        filterChain.doFilter(request, response);
    }
}
