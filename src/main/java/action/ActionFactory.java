package action;

import action.impl.ChangeLanguageAction;
import action.impl.adminAction.*;
import action.impl.cashbox.CreateCashboxAction;
import action.impl.contract.*;
import action.impl.country.*;
import action.impl.tour.*;
import action.impl.user.*;

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
        actions.put(LOG_IN, new UserLoginAction());
        actions.put(LOGOUT, new LogoutAction());
        actions.put(TOUR_LIST,new ShowTourList());
        actions.put(TOUR_LIST_BY_COUNTRY, new ShowTourListByCountry());
        actions.put(EDIT_TOUR_BUTTON,new EditTourButton());
        actions.put(EDIT_TOUR, new UpdateTourAction());
        actions.put(CREATE_TOUR, new CreateTourAction());
        actions.put(SHOW_USER_LIST, new ShowUserList());
        actions.put(DELETE_TOUR, new DeleteTourAction());
        actions.put(DELETE_USER_BY_ADMIN, new DeleteUserByAdmin());
        actions.put(CREATE_COUNTRY,new CreateCountryAction());
        actions.put(SHOW_COUNTRY, new ShowCountryList());
        actions.put(DELETE_COUNTRY, new DeleteCountryAction());
        actions.put(EDIT_COUNTRY, new EditCountryButton());
        actions.put(EDIT_COUNTRY_PARAMETER, new UpdateCountryAction());
        actions.put(CONTRACT, new MyContractButton());
        actions.put(TOUR_CONTRACT, new TourContract());
        actions.put(CASHBOX,new CreateCashboxAction());
        actions.put(FINAL_CONTRACT,new FinalContractButton());
        actions.put(SHOW_ALL_CONTRACT, new ShowAllContract());
        actions.put(DELETE_CONTRACT, new DeleteContractAction());
        actions.put(CHANGE_LANGUAGE, new ChangeLanguageAction());
        actions.put(SHOW_MY_CONTRACT,new ShowMyContract());
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
