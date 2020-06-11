package filter;


import entity.User;
import role.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

public class AuthorizationFilter implements Filter {
    private static final Integer ADMIN = 0;
    private static final Integer CLIENT = 1;
    private static final Integer GUEST = 2;
    HashMap<String, Integer> actions = new HashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        if (role != null) {
            filterChain.doFilter(request, response);

        } else {
            session.setAttribute("role", Role.GUEST);
            filterChain.doFilter(request, response);
        }

   /*     if (getAccessToPageForUserInSession(session, request.getRequestURI())) {
            filterChain.doFilter(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }*/
    }

    @Override
    public void destroy() {

    }

    private boolean getAccessToPageForUserInSession(HttpSession session, String requestURI) {

        User user = (User) session.getAttribute("user");

        if (!user.getAdmin()) {
            return Role.CLIENT.getAccessMap().get(requestURI);
        } else if (user.getAdmin()) {
            return Role.ADMIN.getAccessMap().get(requestURI);
        } else {
            return Role.GUEST.getAccessMap().get(requestURI);
        }
    }

}
