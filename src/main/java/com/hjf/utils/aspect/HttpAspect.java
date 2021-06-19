package com.hjf.utils.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 功能描述:在GirlController.*(..)包下的所有类的所有方法都先被AOP切面(有点像拦截器),
 * 都记录日志操作
 * 
 * 技术点:
 * 1,下面通过Aspect注解来完成AOP面向切面编程,Aop的控制范围通过@Pointcut这个表达式来定义
 * 2,不是在servlet 中如何得到 HttpServletRequest
 * 3,JoinPoint中可以得到类和方法参数等信息
 *
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.hjf.controller.*.*(..))")
    public void filter() {

    }

    @Before("filter()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = (HttpServletRequest) attributes.getRequest();


        logger.info("aop切面编程,请求类型为={}", request.getContentType());//类型
        logger.info("aop切面编程,url={}", request.getRequestURL());   //url
        logger.info("aop切面编程,method={}", request.getMethod());  //method
        logger.info("aop切面编程,ip={}", request.getRemoteAddr());    //ip


        /**
         * get请求时:http://127.0.0.1:8081/user/all
         * 这里可以得到请求为form_urlencode,或application_json类型的请求的参数,但是得不到方法体中参数.
         * 如果要得到方法体中的参数可以通过下面getReader()方法获取,但在post时会出错所以我把它屏蔽了
         */
        Enumeration<String> enumerations = request.getParameterNames();
        while (enumerations.hasMoreElements()){
            String name= enumerations.nextElement();
            String value=request.getParameter(name);
            logger.info("请求url参数为:{}",name + "=" + value);
        }


 /*       Map<String,Object> params = new HashMap<String, Object>();
        BufferedReader br;
        try {
            br = request.getReader();
            String str, wholeStr = "";
            while((str = br.readLine()) != null){
                wholeStr += str;
            }
            if(!StringUtils.isEmpty(wholeStr)){
               // params = JSON.parseObject(wholeStr,Map.class);
                logger.error("方法体的值:{}",wholeStr);//这里要把json转Map
            }
        } catch (IOException e1) {
            logger.error(""+e1);
        }
*/
        //类方法
        logger.info("aop切面编程,class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("aop切面编程,args={}", joinPoint.getArgs());       //参数
    }

    @After("filter()")
    public void doAfter() {
        logger.info("doAfter");
    }

    //returning 就是入参
    @AfterReturning(returning = "object", pointcut = "filter()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object);
    }



    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            T t = MAPPER.readValue(jsonData, beanType);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
