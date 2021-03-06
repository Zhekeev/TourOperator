package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    private static final String REGEX = "^\\+([0-9\\-]?){9,11}[0-9]$";
    private Pattern pattern = Pattern.compile(REGEX);
    private Matcher matcher;
    private boolean result;

    public boolean phoneValidator(String phone) {
        matcher = pattern.matcher(phone);

        if (matcher.find()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
