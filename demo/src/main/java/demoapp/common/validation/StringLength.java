package demoapp.common.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringLengthValidationor.class)
public @interface StringLength {
    int minLength() default 0;
    int maxLength() default Integer.MAX_VALUE;

    String message() default "长度不对，赶紧赶紧改";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
