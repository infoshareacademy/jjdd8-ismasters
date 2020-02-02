package com.isa.filter;

import com.isa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter (
        filterName = "AdminAccessFilter",
        urlPatterns = {"/admin/*"}
)
public class AdminFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private UserService userService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        PrintWriter writer = servletResponse.getWriter();
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html; charset=UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String loggedEmail = (String) httpRequest.getSession().getAttribute("googleEmail");
        Boolean isAdmin = userService.isSuperAdmin(loggedEmail);

        logger.info("Currently logged user: {}", loggedEmail);
        logger.info("Is admin: {}", isAdmin);

        if (isAdmin) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            logger.info("googleId = null or no admin logged");
            ((HttpServletResponse) servletResponse).sendRedirect("/noprivileges");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
