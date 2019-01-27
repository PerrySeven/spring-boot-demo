package demoapp.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class RequestLogAspectConfig {

    private static final Logger logger = LoggerFactory.getLogger(AspectConfig.class);

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

    @AfterReturning(value = "getData()",returning = "returnValue")
    public void doAfterReturn(Object returnValue)
    {

        System.out.println("returnValue:" + returnValue);
    }


    @Around("getData()&&@annotation(myAnnotation)")
    public Object Interceptor(ProceedingJoinPoint pjp,MyAnnotation myAnnotation)
    {
        String keyStr1 = myAnnotation.key();
        System.out.println(keyStr1);
        Object result = null;
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();

//        ra.getAttribute(RequestAttributes.REFERENCE_REQUEST,1);
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();
        Object[] obl = pjp.getArgs();
        //result = request.getRequestURI();
        //logger.info(request.getRequestURI());
        System.out.println(request.getRequestURI());
        // 获取请求头部信息
        request.getHeaderNames();
        System.out.println(request.getMethod());
        System.out.println(request.getQueryString());

        request.getRequestURI();


//        Object result = null;

        Object[] args = pjp.getArgs();

        String id = args[0].toString();
        if ("2".equals(id))
        {
            result += "切片成功！！！";
//            return  result;
        }
//        try {
//            result += pjp.proceed().toString();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }

        try {
            result = pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return result;

    }
}




