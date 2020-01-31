package com.isa.filter;

import com.isa.config.TemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter (
        filterName = "AdminAccessFilter",
        urlPatterns = {"/*"}
)
public class OauthFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Inject
    private TemplateProvider templateProvider;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        Enumeration e = session.getAttributeNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            logger.info(key + " = " + session.getAttribute(key));
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
