package com.isa.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "BeamStatusChecker",
        urlPatterns = {"/*"}
)
public class CheckForBeamStatusFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (httpServletRequest.getSession().getAttribute("beamStatus") == null) {
            httpServletRequest.getSession().setAttribute("beamStatus", "true");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
