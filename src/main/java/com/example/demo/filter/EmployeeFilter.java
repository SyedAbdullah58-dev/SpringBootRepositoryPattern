package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

public class EmployeeFilter implements Filter {

private static final Logger logger=  LoggerFactory.getLogger(EmployeeFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
logger.info("Emp filer");
logger.info("Local Port - "+servletRequest.getLocalPort());
logger.info("Server Name - "+servletRequest.getServerName());
logger.info("Protocol - "+servletRequest.getProtocol());
logger.info("Name - "+servletRequest.getLocalName());
filterChain.doFilter(servletRequest,servletResponse);
    }

}
