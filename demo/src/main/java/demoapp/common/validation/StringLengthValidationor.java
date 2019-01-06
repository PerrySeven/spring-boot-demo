package demoapp.common.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolationException;

public class StringLengthValidationor implements ConstraintValidator<StringLength,Object> {

    private  int min = 0 ;
    private  int max = 0 ;


    @Override
    public void initialize(StringLength stringLength) {
        min = stringLength.minLength();
        max = stringLength.maxLength();
        System.out.println(min);
        System.out.println(max);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int length = o.equals(null) ? 0 : ((String) o).length();

            System.out.println("check object of length:" + length);
            return length <= max && length >= min;
        }
        catch (ConstraintViolationException ex)
        {
            throw ex;
        }
    }
}
