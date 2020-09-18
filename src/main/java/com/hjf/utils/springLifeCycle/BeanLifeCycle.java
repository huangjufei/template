package com.hjf.utils.springLifeCycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {

	public static void main(String[] args) {

		System.out.println("0,现在开始初始化容器");

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("16,容器初始化成功, new ClassPathXmlApplicationContext(\"beans.xml\")才执行完");

		// 得到Preson，并使用
		Person person = ctx.getBean("person", Person.class);
		System.out.println("17,"+person);

		//放开下面xml中bena,11会多次调用;注意11在16容器初始化之前
		//Student s = ctx.getBean("student", Student.class);
		// System.out.println("17,"+s);

		System.out.println("18,现在开始关闭容器！");
		((ClassPathXmlApplicationContext) ctx).registerShutdownHook();
	}
}