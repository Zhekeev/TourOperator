package filter;


import role.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private static final String ROLE = "role";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute(ROLE);
        if (role != null) {
            filterChain.doFilter(request, response);

        } else {
            session.setAttribute(ROLE, Role.GUEST);
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
