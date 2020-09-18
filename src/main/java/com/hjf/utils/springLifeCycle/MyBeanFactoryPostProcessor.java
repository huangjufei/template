package com.hjf.utils.springLifeCycle;

import org.springframework.beans.BeansException;  
import org.springframework.beans.factory.config.BeanDefinition;  
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;  
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 *在 Spring 容器启动 阶段，Spring 还提供了一种容器扩展机制 BeanFactoryPostProcessor，
 * 该机制作用于容器启动阶段，允许在容器实例化 Bean 之前对注册到该容器的 BeanDefinition 做出修改。
 * https://www.jianshu.com/p/a944aef3d23e
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {  
  
   public MyBeanFactoryPostProcessor() {  
       super();  
       System.out.println("1,这是BeanFactoryPostProcessor实现类构造器！！");  
   }

    /**
     * 可以设置单例,BeanDefinition.SCOPE_SINGLETON,
     * postProcessBeanFactory() 方法中，不能进行 Bean 的实例化工作，这样会导致 Bean 过早实例化，导致严重后果。
     * @param arg 里面装着全部BeanDefinition,通过get("id")得到其中一个
     * @throws BeansException
     */
   @Override  
   public void postProcessBeanFactory(ConfigurableListableBeanFactory arg)  
           throws BeansException {  
       System.out  
               .println("2,BeanFactoryPostProcessor调用postProcessBeanFactory方法");  
       BeanDefinition bd = arg.getBeanDefinition("person");
       bd.getPropertyValues().addPropertyValue("phone", "mb这里在给挖坑");
   }   
}  