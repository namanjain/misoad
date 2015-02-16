package utils;

import common.Constants;

/**
 * Created by naman on 2/15/15.
 */
public class LinkUtils {

    public static String getStaffLink(Integer staffId) {
        return Constants.staffLink+"/"+staffId;
    }
    public static String getStoreLink(Integer storeId) {
        return Constants.storeLink+"/"+storeId;
    }
}
