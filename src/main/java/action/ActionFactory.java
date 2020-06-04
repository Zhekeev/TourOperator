package action;

import action.impl.HomePageAction;
import action.impl.contract.FinalContractButton;
import action.impl.contract.MyContract;
import action.impl.contract.MyContractButton;
import action.impl.country.*;
import action.impl.service.*;
import action.impl.user.LogoutAction;
import action.impl.adminAction.DeleteUserByAdmin;
import action.impl.adminAction.EditUserByAdmin;
import action.impl.adminAction.EditUserByAdminButton;
import action.impl.adminAction.ShowUserList;
import action.impl.tour.*;
import action.impl.user.CreateUserAction;
import action.impl.user.UserLoginAction;
import action.impl.user.UserPasswordEdit;
import action.impl.user.UserUpdateAction;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static action.impl.IMPLConstants.*;

public class ActionFactory {
    private static Map<String, Action> actions = new ConcurrentHashMap<>();

    private static ActionFactory instance = null;

    private ActionFactory() {
    }

    static {
        actions.put("/controller/index", new HomePageAction());
        actions.put("/controller/registration", new CreateUserAction());
        actions.put("/controller/update",new UserUpdateAction());
        actions.put("/edit_user_by_admin", new EditUserByAdmin());
        actions.put("/edit_user_by_admin_button" , new EditUserByAdminButton());
        actions.put("/controller/updatepassword", new UserPasswordEdit());
        actions.put("/controller/homepage",new HomePageAction());
        actions.put("/controller/login", new UserLoginAction());
        actions.put(LOGOUT, new LogoutAction());
        actions.put("/controller/tour_list",new ShowTourList());
        actions.put("/controller/edit_tour_but",new EditTourButton());
        actions.put("/controller/edit_tour", new UpdateTourAction());
        actions.put("/controller/create_tour", new CreateTourAction());
        actions.put("/controller/show_user_admin_list", new ShowUserList());
        actions.put("/controller/delete_tour", new DeleteTourAction());
        actions.put(DELETE_USER_BY_ADMIN, new DeleteUserByAdmin());
        actions.put(CREATE_COUNTRY,new CreateCountryAction());
        actions.put(SHOW_COUNTRY_LIST_ADMIN, new ShowCountryList());
        actions.put(DELETE_COUNTRY, new DeleteCountryAction());
        actions.put(EDIT_COUNTRY, new EditCountryButton());
        actions.put(EDIT_COUNTRY_PARAMETER, new UpdateCountryAction());
        actions.put(CREATE_SERVICE, new CreateServiceAction());
        actions.put(SHOW_SERVICE_LIST_ADMIN, new ShowServiceList());
        actions.put(DELETE_SERVICE, new DeleteServiceAction());
        actions.put(EDIT_SERVICE, new EditServiceButton());
        actions.put(EDIT_SERVICE_PARAMETER, new UpdateServiceAction());
        actions.put(MY_CONTRACT, new MyContractButton());
        actions.put(MY_CONTRACT_REGISTER,new MyContract());
        actions.put("/finalcontract",new FinalContractButton());
        actions.put("/controller/upload_image_button",new UploadImageButton());

    }

    public static ActionFactory getInstance() {

        if (instance == null) {
            instance = new ActionFactory();
        }
        return instance;
    }

    public Action getAction(HttpServletRequest request) {
        Action action = actions.get(request.getRequestURI());
        if(action == null){
            System.out.println("action null");
        }
        return action;
    }
}
