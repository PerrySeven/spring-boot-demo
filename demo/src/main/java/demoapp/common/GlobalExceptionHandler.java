package demoapp.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {


    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = ConstraintViolationException.class)
    public String constraintionExceptionHandle(HttpServletRequest request, ConstraintViolationException exception)
    {
        System.out.println("aaaaaaa");
        //System.out.println("error:"+exception.getConstraintViolations());
        logger.error("参数验证失败", exception);
        Set<ConstraintViolation<?>> violations = exception.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();
        return "参数验证失败" + message;
//        BindingResult result = exception.getConstraintViolations();
//
//        return  exception.getMessage();
    }

    /*
    参数校验的异常类
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String validationBodyException(MethodArgumentNotValidException exception){

        System.out.println("getInfomation");
        BindingResult result = exception.getBindingResult();
        if (result.hasErrors()) {

            List<ObjectError> errors = result.getAllErrors();

            errors.forEach(p ->{

                FieldError fieldError = (FieldError) p;
                logger.error("Data check failure : object{"+fieldError.getObjectName()+"},field{"+fieldError.getField()+
                        "},errorMessage{"+fieldError.getDefaultMessage()+"}");

            });

        }
        return "请填写正确信息";
    }

    /**
     * 参数类型转换错误
     *
     * @param exception 错误
     * @return 错误信息
     */
    @ExceptionHandler(HttpMessageConversionException.class)
    public String parameterTypeException(HttpMessageConversionException exception){

        logger.error(exception.getCause().getLocalizedMessage());
        return "类型转换错误";

    }


}
