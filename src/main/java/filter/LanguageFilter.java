package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LanguageFilter implements Filter {
    public static final String LANGUAGE = "language";
    public static final String LOCAL = "local";
    private static final String CONFIG_LANGUAGE_ID_NAME = "defaultLanguageID";
    private static final String CONFIG_LANGUAGE_NAME = "defaultLanguage";
    private Integer defaultLanguageID;
    private String defaultLanguage;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        defaultLanguageID = Integer.parseInt(filterConfig.getInitParameter(CONFIG_LANGUAGE_ID_NAME));
        defaultLanguage = filterConfig.getInitParameter(CONFIG_LANGUAGE_NAME);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession(true);

        String language = (String) session.getAttribute(LANGUAGE);

        if (language == null) {
            session.setAttribute(LANGUAGE, defaultLanguage);
        } else if (language.equalsIgnoreCase("en_US")) {
            session.setAttribute(LANGUAGE, "en_US");
        } else if (language.equalsIgnoreCase("ru_RU")) {
            session.setAttribute(LANGUAGE, "ru_RU");
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
