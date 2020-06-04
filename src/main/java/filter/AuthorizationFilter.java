package filter;


import role.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

import static action.impl.IMPLConstants.*;

public class AuthorizationFilter implements Filter {
    private static final Integer ADMIN = 0;
    private static final Integer CLIENT = 1;
    private static final Integer GUEST = 2;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        HashMap<String, Integer> actions = new HashMap<>();
        actions.put("/controller/index", GUEST);
        actions.put("/controller/registration", GUEST);
        actions.put("/controller/update", CLIENT);
        actions.put("/edit_user_by_admin", ADMIN);
        actions.put("/edit_user_by_admin_button" , ADMIN);
        actions.put("/controller/updatepassword", GUEST);
        actions.put("/controller/homepage", GUEST);
        actions.put("/controller/login", GUEST);
        actions.put("/controller/logout", CLIENT);
        actions.put("/controller/tour_list", ADMIN);
        actions.put("/controller/edit_tour_but", ADMIN);
        actions.put("/controller/edit_tour", ADMIN);
        actions.put("/controller/create_tour", ADMIN);
        actions.put("/controller/show_user_admin_list", ADMIN);
        actions.put("/controller/delete_tour", ADMIN);
        actions.put(DELETE_USER_BY_ADMIN, ADMIN);
        actions.put(CREATE_COUNTRY, ADMIN);
        actions.put(SHOW_COUNTRY_LIST_ADMIN, ADMIN);
        actions.put(DELETE_COUNTRY, ADMIN);
        actions.put(EDIT_COUNTRY, ADMIN);
        actions.put(EDIT_COUNTRY_PARAMETER, ADMIN);
        actions.put(CREATE_SERVICE, ADMIN);
        actions.put(SHOW_SERVICE_LIST_ADMIN, ADMIN);
        actions.put(DELETE_SERVICE, ADMIN);
        actions.put(EDIT_SERVICE, ADMIN);
        actions.put(EDIT_SERVICE_PARAMETER, ADMIN);
        actions.put("/controller/upload_image_button", ADMIN);
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
    }

    @Override
    public void destroy() {

    }
}
