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

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        final String header = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);

        if(isEmpty(header) || !header.startsWith("Bearer") || header==null){
            return;
        }
        final String token = header.split(" ")[1].trim();
        if (!token.equals("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9")){
            httpResponse.sendError(401, "Invalid Authorization code/ Unauthorized");
            //return;
        }
        filterChain.doFilter(request,response);
    }
}
