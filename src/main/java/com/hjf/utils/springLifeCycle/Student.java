package com.hjf.utils.springLifeCycle;

public class Student {


    private String classes;

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("13,Student【init-method】调用<bean>的init-method属性指定的初始化方法");
    }


    @Override
    public String toString() {
        return "Student{" +
                "classes='" + classes + '\'' +
                '}';
    }
}
