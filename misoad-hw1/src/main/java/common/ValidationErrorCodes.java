package common;

/**
 * Created by naman on 2/15/15.
 */
public enum ValidationErrorCodes {

    MISSING_FIRST_NAME("First name is missing"),
    MISSING_LAST_NAME("Last name is missing"),
    INVALID_EMAIL("Invalid email format"),
    INVALID_TIMESTAMP("Invalid timestamp format. Accepted format: MM/DD/YYYY");

    String errorDetail;

    private ValidationErrorCodes(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }
}
