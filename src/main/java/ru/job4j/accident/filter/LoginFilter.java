package ru.job4j.accident.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        if (uri.endsWith("loginPage") || uri.endsWith("login") ||
                uri.endsWith("registerPage") || uri.endsWith("register") || uri.endsWith("startPage")) {
            chain.doFilter(req, resp);
            return;
        }
        if (req.getSession().getAttribute("user") == null) {
            resp.sendRedirect(req.getContextPath() + "/loginPage");
            return;
        }
        chain.doFilter(req, resp);
    }

}
