/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cigist.belajarweb.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Irwan Cigist <cigist.developer@gmail.com>
 */
@WebFilter(filterName = "filterApp", urlPatterns = {"/*"})
public class FilterApp implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter diinisialisasi");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Mencegat request");
        chain.doFilter(request, response);
        System.out.println("Mencegat response");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();
        Cookie[] cookie = httpRequest.getCookies();
        System.out.println("Cookie :" + request.getInputStream());
        
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                System.out.println("Header: " + httpRequest.getHeader(headerNames.nextElement()));
            }
        }
        Map<String, String[]> parameterNames = request.getParameterMap();
        for (Map.Entry m : parameterNames.entrySet()) {
            System.out.println(m.getKey() + " " + request.getParameter(m.getKey().toString()));
        }
        
        Cookie cUsername = new Cookie("user", request.getParameter("name"));
    }

    @Override
    public void destroy() {
        System.out.println("Filter di-destroy");
    }

}
