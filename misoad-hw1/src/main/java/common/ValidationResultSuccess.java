package common;

public class ValidationResultSuccess<T> implements ValidationResult {

    ValidationResultType validationResultType;
    T entity;

    public ValidationResultSuccess() {
        validationResultType = ValidationResultType.success;
    }

    public ValidationResultSuccess(T entity) {
        this.validationResultType = ValidationResultType.success;
        this.entity = entity;
    }

    @Override
    public ValidationResultType getValidationResultType() {
        return null;
    }

    @Override
    public Object getEntity() {
        return null;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }
}
