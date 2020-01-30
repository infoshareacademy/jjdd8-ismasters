//package com.isa.filter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//@WebFilter (
//        filterName = "IdAndBeamStatusChecker",
//        urlPatterns = {"/*"}
//)
//public class CheckForIdAndBeamStatusFilter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
//
//        HttpSession session = ((HttpServletRequest) request).getSession();
//        session.getAttribute();
//
//        filterChain.doFilter(request, response);
//    }
//}
