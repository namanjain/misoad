package common;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ValidationResultFailure implements ValidationResult<List<ValidationErrorCodes>> {

    ValidationResultType validationResultType;
    List<ValidationErrorCodes> errors;

    public ValidationResultFailure() {
        validationResultType = ValidationResultType.failure;
        this.errors = new ArrayList<ValidationErrorCodes>();
    }

    public ValidationResultFailure(List<ValidationErrorCodes> errors) {
        validationResultType = ValidationResultType.failure;
        this.errors = errors;
    }

    @Override
    public ValidationResultType getValidationResultType() {
        return null;
    }

    @Override
    public List<ValidationErrorCodes> getEntity() {
        return null;
    }

    public void setErrors(List<ValidationErrorCodes> errors) {
        this.errors = errors;
    }

    public void addError(ValidationErrorCodes error) {
        if(CollectionUtils.isEmpty(this.errors)) {
            this.errors = new ArrayList<ValidationErrorCodes>();
        }
        this.errors.add(error);
    }
}
