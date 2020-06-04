package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static final String REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private Pattern validEmail;
    private Matcher matcher;
    private boolean result;

    public boolean emailValidator(String email) {
        validEmail= Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        matcher = validEmail.matcher(email);
        if(matcher.find()){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}