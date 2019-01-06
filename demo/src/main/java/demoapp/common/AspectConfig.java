package demoapp.common;

import com.alibaba.fastjson.JSONObject;
import demoapp.common.validation.StringLength;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class AspectConfig {

//    @Pointcut("execution(public * demoapp.controller.AspectDemController.getData*(..)) && @annotation(demoapp.common.MyAnnotation)")
    @Pointcut("@annotation(demoapp.common.MyAnnotation)")
    public void getData(){}

    @Before("getData()")
    public void doBeforeRequest()
    {
        System.out.println("before");
    }

    @After("getData()")
    public void doAfterRequest()
    {
        System.out.println("after");
    }

    @Around("getData()")
    public Object Interceptor(ProceedingJoinPoint pjp)
    {
        Object result = null;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

//        ra.getAttribute(RequestAttributes.REFERENCE_REQUEST,1);
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        //result = request.getRequestURI();

        request.getRequestURI();


//        Object result = null;

        Object[] args = pjp.getArgs();

        String id = args[0].toString();
        if ("2".equals(id))
        {
            result += "切片成功！！！";
//            return  result;
        }
        try {
            result += pjp.proceed().toString();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return result;

    }

    //@Pointcut("execution(public * demoapp.controller..*.*(..)) && @annotation(demoapp.common.validation.StringLength)")
    @Pointcut("execution(public * demoapp.controller..*(..))")
    public void validation(){}

    @Around("validation()")
    public Object InterceptorValidation(ProceedingJoinPoint pjp) throws Throwable {
        Object[] oarr =  pjp.getArgs();
        MethodSignature method =  (MethodSignature) pjp.getSignature();
        Method method1 = method.getMethod();
        Annotation[][] params = method1.getParameterAnnotations();

        StringLength an=  pjp.getClass().getAnnotation(StringLength.class);
        StringLength san=  pjp.getThis().getClass().getAnnotation(StringLength.class);
        Annotation[] ans1=  pjp.getThis().getClass().getAnnotations();
        Annotation[] ans2=  pjp.getTarget().getClass().getAnnotations();
        //int min = stringLength.minLength();
        //int max = stringLength.maxLength();

        pjp.getClass();
        return pjp.proceed() ;
    }

}
