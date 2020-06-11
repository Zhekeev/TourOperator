package action.impl.access;

import java.util.concurrent.ConcurrentHashMap;

import static constant.IMPLConstants.*;

public class UserMapAccess {

    public static ConcurrentHashMap<String, Boolean> accessClientMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Boolean> accessAdminMap = new ConcurrentHashMap<>();
    public static ConcurrentHashMap<String, Boolean> accessGuestMap = new ConcurrentHashMap<>();

    static {

        accessClientMap.put("/controller/index", true);
        accessClientMap.put("/controller/registration", true);
        accessClientMap.put("/controller/update", true);
        accessClientMap.put("/edit_user_by_admin", false);
        accessClientMap.put("/edit_user_by_admin_button", false);
        accessClientMap.put("/controller/updatepassword", true);
        accessClientMap.put("/controller/homepage", true);
        accessClientMap.put("/controller/login", true);
        accessClientMap.put("/controller/logout", true);
        accessClientMap.put("/controller/tour_list", true);
        accessClientMap.put("/controller/edit_tour_but", false);
        accessClientMap.put("/controller/edit_tour", false);
        accessClientMap.put("/controller/create_tour", false);
        accessClientMap.put("/controller/show_user_admin_list", false);
        accessClientMap.put("/controller/delete_tour", false);
        accessClientMap.put(DELETE_USER_BY_ADMIN, false);
        accessClientMap.put(CREATE_COUNTRY, false);
        accessClientMap.put(SHOW_COUNTRY_LIST_ADMIN, false);
        accessClientMap.put(DELETE_COUNTRY, false);
        accessClientMap.put(EDIT_COUNTRY, false);
        accessClientMap.put(EDIT_COUNTRY_PARAMETER, false);
        accessClientMap.put(CREATE_SERVICE, false);
        accessClientMap.put(SHOW_SERVICE_LIST_ADMIN, false);
        accessClientMap.put(DELETE_SERVICE, false);
        accessClientMap.put(EDIT_SERVICE, false);
        accessClientMap.put(EDIT_SERVICE_PARAMETER, false);
        accessClientMap.put("/controller/upload_image_button", false);


        accessAdminMap.put("/controller/index", true);
        accessAdminMap.put("/controller/registration", true);
        accessAdminMap.put("/controller/update", true);
        accessAdminMap.put("/edit_user_by_admin", true);
        accessAdminMap.put("/edit_user_by_admin_button", true);
        accessAdminMap.put("/controller/updatepassword", true);
        accessAdminMap.put("/controller/homepage", true);
        accessAdminMap.put("/controller/login", true);
        accessAdminMap.put("/controller/logout", true);
        accessAdminMap.put("/controller/tour_list", true);
        accessAdminMap.put("/controller/edit_tour_but", true);
        accessAdminMap.put("/controller/edit_tour", true);
        accessAdminMap.put("/controller/create_tour", true);
        accessAdminMap.put("/controller/show_user_admin_list", true);
        accessAdminMap.put("/controller/delete_tour", true);
        accessAdminMap.put(DELETE_USER_BY_ADMIN, true);
        accessAdminMap.put(CREATE_COUNTRY, true);
        accessAdminMap.put(SHOW_COUNTRY_LIST_ADMIN, true);
        accessAdminMap.put(DELETE_COUNTRY, true);
        accessAdminMap.put(EDIT_COUNTRY, true);
        accessAdminMap.put(EDIT_COUNTRY_PARAMETER, true);
        accessAdminMap.put(CREATE_SERVICE, true);
        accessAdminMap.put(SHOW_SERVICE_LIST_ADMIN, true);
        accessAdminMap.put(DELETE_SERVICE, true);
        accessAdminMap.put(EDIT_SERVICE, true);
        accessAdminMap.put(EDIT_SERVICE_PARAMETER, true);
        accessAdminMap.put("/controller/upload_image_button", true);


        accessGuestMap.put("/controller/index", true);
        accessGuestMap.put("/controller/registration", true);
        accessGuestMap.put("/controller/update", false);
        accessGuestMap.put("/edit_user_by_admin", false);
        accessGuestMap.put("/edit_user_by_admin_button", false);
        accessGuestMap.put("/controller/updatepassword", false);
        accessGuestMap.put("/controller/homepage", true);
        accessGuestMap.put("/controller/login", true);
        accessGuestMap.put("/controller/logout", false);
        accessGuestMap.put("/controller/tour_list", false);
        accessGuestMap.put("/controller/edit_tour_but", false);
        accessGuestMap.put("/controller/edit_tour", false);
        accessGuestMap.put("/controller/create_tour", false);
        accessGuestMap.put("/controller/show_user_admin_list", false);
        accessGuestMap.put("/controller/delete_tour", false);
        accessGuestMap.put(DELETE_USER_BY_ADMIN, false);
        accessGuestMap.put(CREATE_COUNTRY, false);
        accessGuestMap.put(SHOW_COUNTRY_LIST_ADMIN, false);
        accessGuestMap.put(DELETE_COUNTRY, false);
        accessGuestMap.put(EDIT_COUNTRY, false);
        accessGuestMap.put(EDIT_COUNTRY_PARAMETER, false);
        accessGuestMap.put(CREATE_SERVICE, false);
        accessGuestMap.put(SHOW_SERVICE_LIST_ADMIN, false);
        accessGuestMap.put(DELETE_SERVICE, false);
        accessGuestMap.put(EDIT_SERVICE, false);
        accessGuestMap.put(EDIT_SERVICE_PARAMETER, false);
        accessGuestMap.put("/controller/upload_image_button", false);
    }
}
