package utils;

/**
 * Created by naman on 2/15/15.
 */
public class StringUtils {

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(String str) {
        return ( str == null || str.isEmpty() );
    }
}
