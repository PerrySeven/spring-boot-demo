package demoapp.common;

import demoapp.common.validation.StringLength;
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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class AspectConfig {

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

    @Around("getData()")
    public Object Interceptor(ProceedingJoinPoint pjp)
    {
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

    /*
    通过反射获取到对应的属性下面的数据
    */
    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }
        return map;
    }
}
