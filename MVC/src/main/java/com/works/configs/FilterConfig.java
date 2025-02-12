package com.works.configs;

import com.works.entities.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Configuration;
import java.io.IOException;

@Configuration
public class FilterConfig implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();
        String[] urls = {"/", "/login"};
        boolean loginStatus = true;
        for( String item : urls ) {
            if (  url.equals(item) ) {
                loginStatus = false;
            }
        }

        if ( loginStatus ) {
            boolean status = req.getSession().getAttribute("admin") == null;
            if ( status ) {
                // oturum yok!
                res.sendRedirect("http://localhost:8090/");
            }else {
                Admin admin = (Admin) req.getSession().getAttribute("admin");
                req.setAttribute("admin", admin);
            }
        }

        chain.doFilter(req, res);
    }

}