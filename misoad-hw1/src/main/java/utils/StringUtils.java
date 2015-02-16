package utils;

public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return ( str == null || str.isEmpty() );
    }
}
