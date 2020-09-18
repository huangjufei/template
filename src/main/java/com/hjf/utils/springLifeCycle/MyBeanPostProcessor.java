package com.hjf.utils.springLifeCycle;

import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 11和14相当于实例化的前、后置处理
 */
public class MyBeanPostProcessor implements BeanPostProcessor {  
  
    public MyBeanPostProcessor() {  
       super();  
       System.out.println("3,这是BeanPostProcessor 实现类构造器！！");
   }

    /**
     * 用自定义注解的时候会判断这些bean的字段是否包含我们的自定义注解，当然了还有其他的一些用途
     * @param arg 当前对象,如Person
     * @param str 就是id
     */
    @Override  
    public Object postProcessBeforeInitialization(Object arg, String str)  
            throws BeansException {  
        System.out.println("11,BeanPostProcessor 接口方法postProcessBeforeInitialization,在init之前被调用," +
                "现在实例已经有属性值了！");
        if(arg instanceof Person){
            Person p = (Person)arg;
            p.setPhone("我在init之前修改phone的值");
        }
        return arg;
    }  
    
   @Override  
   public Object postProcessAfterInitialization(Object arg, String str)  
           throws BeansException {  
       System.out.println("14,BeanPostProcessor 接口方法postProcessAfterInitialization,init之后被调用！");
       return arg;  
   }  
 
}  