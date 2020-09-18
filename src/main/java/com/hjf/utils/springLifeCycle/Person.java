package com.hjf.utils.springLifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

	private String name;
	private String address;
	private String phone;


	private BeanFactory beanFactory;
	private String beanName;

	public Person() {
		System.out.println("6,【构造器】调用Person的构造器实例化");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("8,【注入属性】注入属性name");
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("8,【注入属性】注入属性address");
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		System.out.println("8,【注入属性】注入属性phone=" + phone);
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + ", phone=" + phone + ", beanFactory="
				+ beanFactory + ", beanName=" + beanName + "]";
	}

	// 这是BeanFactoryAware接口方法
	@Override
	public void setBeanFactory(BeanFactory arg) throws BeansException {
		System.out.println("10,【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
		Person p = (Person)arg.getBean("person");
		p.setPhone("我在次修改值10");
		this.beanFactory = arg;
	}

	// 这是BeanNameAware接口方法
	@Override
	public void setBeanName(String arg) {
		System.out.println("9,【BeanNameAware接口】调用BeanNameAware.setBeanName()");
		//arg的值默就是类名小写,但设置id就是以id为准
		this.beanName = arg;
	}

	// 这是InitializingBean接口方法
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("12,【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
	}

	// 这是DiposibleBean接口方法
	@Override
	public void destroy() throws Exception {
		System.out.println("19,【DiposibleBean接口】调用DiposibleBean.destory()");
	}

	// 通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("13,【init-method】调用<bean>的init-method属性指定的初始化方法");
	}

	// 通过<bean>的destroy-method属性指定的初始化方法
	public void myDestory() {
		System.out.println("20,【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
	}
}