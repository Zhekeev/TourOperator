package action.impl.user;

import action.Action;
import connection.ConnectionPoolException;
import dao.impl.UserDaoImpl;
import entity.User;
import service.HashPassword;
import validator.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static action.impl.IMPLConstants.*;

public class UserUpdateAction implements Action {
    private UserDaoImpl clientDao = new UserDaoImpl();
    private User user = new User();
    private int id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;
    private String iin;
    private String dateOfIin;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ConnectionPoolException {
        login = request.getParameter(LOGIN);
        password = request.getParameter(PASSWORD);
        firstName = request.getParameter(FIRST_NAME);
        lastName = request.getParameter(LAST_NAME);
        email = request.getParameter(EMAIL);
        phoneNumber = request.getParameter(PHONE_NUMBER);
        address = request.getParameter(ADDRESS);
        gender = request.getParameter(GENDER);
        iin = request.getParameter(IIN);
        dateOfIin = request.getParameter(DATE_OF_IIN);

        if(!new LoginValidator().loginValidator(login) || !new PasswordValidator().passwordValidator(password)
                || !new EmailValidator().emailValidator(email) || !new PhoneNumberValidator().phoneValidator(phoneNumber)
                || !new GenderValidator().genderValidator(gender) || !new IINValidator().IINValidator(iin) ){
            request.setAttribute("message","Ошибка,  данные введены некоректно");
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }
        if(login.isEmpty() || password.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()
                || phoneNumber.isEmpty() || address.isEmpty() || gender.isEmpty() || iin.isEmpty()
                || dateOfIin.isEmpty()){
            request.setAttribute("message","Ошибка, данные пустые");
            request.getRequestDispatcher(ERROR_URL).forward(request,response);
        }

        HashPassword hashPassword = new HashPassword();
        password = hashPassword.getHashPassword(password);
        user.setLogin(login);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setGender(gender);
        user.setIIN(iin);
        user.setDateOfIIN(dateOfIin);
        user.setAdmin(true);

        try {
            clientDao.update(user.getId(), user);
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(HOME_PAGE_URL);
        requestDispatcher.forward(request, response);
    }
}
