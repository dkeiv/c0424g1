import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String phone = "(84)-(0978489648)";
        System.out.println(isValidPhone(phone));

        String className = "M0318G";
        System.out.println(isValidClassName(className));
    }

    private static boolean isValidClassName(String className) {
        Pattern pattern = Pattern.compile("^[CAP]\\d{4}[GHIK]$");
        Matcher matcher = pattern.matcher(className);
        return matcher.matches();
    }

    private static boolean isValidPhone(String phone) {
        Pattern pattern = Pattern.compile("^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}