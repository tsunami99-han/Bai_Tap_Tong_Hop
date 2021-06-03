import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    static final String ID_REGEX = "^(C)\\d{4}[G|H|I|K]{1}\\d{2}$";
    static final String DATEOFBIRTH_REGEX = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    static final String EMAIL_REGEX = "^[a-zA-Z]{1,7}.[a-zA-Z]{2,7}(@codegym.vn){1}";
    static final String GENDER_REGEX="^[1|2|0]";
    public Validation() {
    }


    public static boolean validate(String regex,String string) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }
}
