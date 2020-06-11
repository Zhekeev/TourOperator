package action;

import action.impl.ChangeLanguageAction;
import action.impl.HomePageAction;
import action.impl.cashbox.CreateCashboxAction;
import action.impl.contract.ContractWithoutService;
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

import static constant.IMPLConstants.*;

public class ActionFactory {
    private static Map<String, Action> actions = new ConcurrentHashMap<>();

    private static ActionFactory instance = null;

    private ActionFactory() {
    }

    static {
        actions.put(REGISTRATION, new CreateUserAction());
        actions.put(USER_EDIT,new UserUpdateAction());
        actions.put(USER_EDIT_BY_ADMIN, new EditUserByAdmin());
        actions.put(USER_EDIT_BY_ADMIN_PARAMETER, new EditUserByAdminButton());
        actions.put(USER_UPDATE_PASSWORD, new UserPasswordEdit());
        actions.put(HOME_PAGE,new HomePageAction());
        actions.put(LOG_IN, new UserLoginAction());
        actions.put(LOGOUT, new LogoutAction());
        actions.put(TOUR_LIST,new ShowTourList());
        actions.put(TOUR_LIST_BY_COUNTRY, new ShowTourListByCountry());
        actions.put("/manage/edit_tour_but",new EditTourButton());
        actions.put("/manage/edit_tour", new UpdateTourAction());
        actions.put("/manage/create_tour", new CreateTourAction());
        actions.put("/manage/show_user_admin_list", new ShowUserList());
        actions.put("/manage/delete_tour", new DeleteTourAction());
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
        actions.put(CONTRACT_WITHOUT_SERVICE, new ContractWithoutService());
        actions.put(CASHBOX,new CreateCashboxAction());
        actions.put("/final_contract",new FinalContractButton());
        actions.put("/change_language", new ChangeLanguageAction());
        actions.put(UPLOAD_IMAGE_PARAMETER,new UploadImageButton());

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
            return action;
        }
        return action;
    }
}
