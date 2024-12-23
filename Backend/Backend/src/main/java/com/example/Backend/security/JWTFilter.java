package com.example.Backend.security;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.Backend.service.AccountService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
public class JWTFilter extends OncePerRequestFilter {
    @Autowired private MyAccountService myAccountService;
    @Autowired private JWTUtil jwtUtil;
    @Autowired private AccountService accountService;
    @Autowired private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String jwt = getJwtFromRequest(request);
        if (jwt != null /*&& jwtUtil.validateToken(jwt, jwtUtil.getUsernameFromToken(jwt))*/) {
            String username = "jwtUtil.getUsernameFromToken(jwt)";
            var userDetails = userDetailsService.loadUserByUsername(username);
            var authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        chain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//        throws ServletException, IOException {
//        String authHeader = request.getHeader("Authorization");
//        if (authHeader != null && !authHeader.isBlank() && authHeader.startsWith("Bearer ")) {
//            String jwt = authHeader.substring(7);
//            if (jwt == null || jwt.isBlank()) {
//                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
//            }
//            else {
//                try {
//                    String username = jwtUtil.validateTokenAndRetrieveSubject(jwt);
//                    UserDetails account = myAccountService.loadUserByUsername(username);
//                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, account.getPassword(), account.getAuthorities());
//                    if (SecurityContextHolder.getContext().getAuthentication() == null) {
//                        SecurityContextHolder.getContext().setAuthentication(authToken);
//                    }
//                }
//                catch (JWTVerificationException exc) {
//                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token");
//                }
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
}
