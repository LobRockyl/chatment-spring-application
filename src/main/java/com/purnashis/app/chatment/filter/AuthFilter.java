package com.purnashis.app.chatment.filter;

import com.purnashis.app.chatment.Repo.FactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.apache.logging.log4j.util.Strings.isEmpty;

public class AuthFilter implements Filter {
    @Autowired
    private FactRepo factRepo;
//
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println("here in dofilter");
//        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
//        if(isEmpty(header) || !header.startsWith("Bearer") ){
//            filterChain.doFilter(request,response);
//            return;
//        }
//        final String token = header.split(" ")[1].trim();
//        if (token != "asdfghjkl"){
//            filterChain.doFilter(request,response);
//            return;
//        }
//        //SecurityContextHolder.getContext().setAuthentication(authentication);
//        filterChain.doFilter(request,response);
//    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        final String header = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if(isEmpty(header) || !header.startsWith("Bearer") || header==null){
            return;
        }
        final String token = header.split(" ")[1].trim();
        System.out.println(token);
        if (!token.equals("asdfghjkl")){
            return;
        }
        filterChain.doFilter(request,response);
    }
}
