package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IINValidator    {
    private static final String REGEX = "^[0-9]{12}$";
    private Pattern pattern = Pattern.compile(REGEX);
    private Matcher matcher;
    private boolean result;

    public boolean IINValidator(String iin) {
        pattern = Pattern.compile(REGEX);
        matcher = pattern.matcher(iin);

        if (matcher.find()) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
