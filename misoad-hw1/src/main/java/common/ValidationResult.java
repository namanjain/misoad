package common;

import java.util.List;

public interface ValidationResult<T> {

    public ValidationResultType getValidationResultType();
    public T getEntity();

}
