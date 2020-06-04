package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    public static final String LANGUAGE = "language";
    public static final String LOCAL = "local";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        String en_EN = "en";

        if (req.getParameter(LANGUAGE) != null) {
            session.setAttribute(LOCAL, req.getParameter(LANGUAGE));
        } else if (session.getAttribute(LOCAL) != null) {
            String locale = (String) session.getAttribute(LOCAL);
            session.setAttribute(LOCAL, locale);
        } else {
            session.setAttribute(LOCAL, en_EN);
        }

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
