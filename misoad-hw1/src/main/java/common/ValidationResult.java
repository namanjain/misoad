package common;

import java.util.List;

/**
 * Created by naman on 2/15/15.
 */
public interface ValidationResult<T> {

    public ValidationResultType getValidationResultType();
    public T getEntity();

}
