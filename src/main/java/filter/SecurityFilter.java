package filter;


import entity.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static constant.IMPLConstants.*;

public class SecurityFilter implements Filter {
    private static final String MANAGE = "/manage";
    private static final String ACCESS_DENIED = "Access denied";
    private static final String NOT_LOGGED_USER_REDIRECTED_TO_NOME_PAGE = "Not logged user redirected to nome page";
    private static final String ALREADY_LOGGED_IN = "Already log in";
    private List<String> guestAccessList=new ArrayList<>();
    private Logger logger = Logger.getLogger(SecurityFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        guestAccessList.add(INDEX_URL);
        guestAccessList.add(LOG_IN_URL);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest) servletRequest, (HttpServletResponse) servletResponse, filterChain);
    }

    private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String requestURI = request.getRequestURI();
        if (user == null) {
            if (!guestAccessList.contains(requestURI)) {
                response.sendRedirect(HOME_PAGE_URL);
                logger.info(NOT_LOGGED_USER_REDIRECTED_TO_NOME_PAGE);
                return;
            }
        } else if (requestURI.equals(LOG_IN_URL)) {
            request.setAttribute("message", "Вы уже вошли");
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
            return;
        } else if (!user.getAdmin()) {
            if (requestURI.startsWith(MANAGE)) {
                response.sendError(403, ACCESS_DENIED);
                return;
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
