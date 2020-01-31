package com.isa.filter;

import com.isa.config.TemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter (
        filterName = "AdminAccessFilter",
        urlPatterns = {"/admin/*"}
)
public class AdminFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        PrintWriter writer = servletResponse.getWriter();
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html; charset=UTF-8");

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;

        String isLogged = (String) httpRequest.getSession().getAttribute("googleId");

        logger.info("isLogged: {}", isLogged);

        if (httpRequest.getSession().getAttribute("googleId") == null) {
            writer.println("<h2>Admin privileges required</h2>");
            logger.info("Admin variable not set");
        } else {
            logger.info("Session admin value: {}", isLogged);
            if (isLogged == null) {
                logger.info("Session attribute admin set to: {}", isLogged);
                writer.println("<h2>Admin privileges required</h2>");
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
