package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator {
    private static final String REGEX = "^[a-zA-Z0-9]+$";
    private Pattern pattern;
    private Matcher matcher;
    private boolean result;

    public boolean loginValidator(String login) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(login);
        if(matcher.find()){
            result = true;
        }else {
            result = false;
        }
        return result;
    }
}
