package validator;

public class GenderValidator {
    private static final String MAN = "man";
    private static final String WOMAN = "woman";
    private boolean result;

    public boolean genderValidator(String gender) {

        if (gender.equalsIgnoreCase(MAN) || gender.equalsIgnoreCase(WOMAN)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
