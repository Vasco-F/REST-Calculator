package com.wit.rest.application;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AddIdResponseHeaderFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
                
                HttpServletResponse httpServletResponse = (HttpServletResponse) response;
                String uuid = UUID.randomUUID().toString();
                httpServletResponse.addHeader("Request-Id", uuid);
                chain.doFilter(request, response);        
    }
    
}
