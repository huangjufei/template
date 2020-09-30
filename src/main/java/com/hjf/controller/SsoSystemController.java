package com.hjf.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjf.entity.Page;
import com.hjf.entity.SsoSystem;
import com.hjf.service.SsoSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 系统表 前端控制器
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 * <p>
 * mybatisPlus的crud 请参考官网,且还有很多开源项目
 * https://baomidou.com/guide/#%E7%89%B9%E6%80%A7
 * <p>
 * 特性:
 * 无侵入：只做增强不做改变，引入它不会对现有工程产生影响，如丝般顺滑
 * 损耗小：启动即会自动注入基本 CURD，性能基本无损耗，直接面向对象操作
 * 强大的 CRUD 操作：内置通用 Mapper、通用 Service，仅仅通过少量配置即可实现单表大部分 CRUD 操作，更有强大的条件构造器，满足各类使用需求
 * 支持 Lambda 形式调用：通过 Lambda 表达式，方便的编写各类查询条件，无需再担心字段写错
 * 支持主键自动生成：支持多达 4 种主键策略（内含分布式唯一 ID 生成器 - Sequence），可自由配置，完美解决主键问题
 * 支持 ActiveRecord 模式：支持 ActiveRecord 形式调用，实体类只需继承 Model 类即可进行强大的 CRUD 操作
 * 支持自定义全局通用操作：支持全局通用方法注入（ Write once, use anywhere ）
 * 内置代码生成器：采用代码或者 Maven 插件可快速生成 Mapper 、 Model 、 Service 、 Controller 层代码，支持模板引擎，更有超多自定义配置等您来使用
 * 内置分页插件：基于 MyBatis 物理分页，开发者无需关心具体操作，配置好插件之后，写分页等同于普通 List 查询
 * 分页插件支持多种数据库：支持 MySQL、MariaDB、Oracle、DB2、H2、HSQL、SQLite、Postgre、SQLServer 等多种数据库
 * 内置性能分析插件：可输出 Sql 语句以及其执行时间，建议开发测试时启用该功能，能快速揪出慢查询
 * 内置全局拦截插件：提供全表 delete 、 update 操作智能分析阻断，也可自定义拦截规则，预防误操作
 */
@Controller
@RequestMapping("/ssoSystem")
public class SsoSystemController {


    @Autowired
    private SsoSystemService ssoSystemService;

    /**
     * list查询,总是成功
     *
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public List<SsoSystem> list() {
        List<SsoSystem> list = ssoSystemService.list();
        return list;
    }

    /**
     * 带条件的list查询,前端传入几个参数都会进行比对
     *
     * @param ssoSystem
     * @return
     */
    @GetMapping("/listByCondition")
    @ResponseBody
    public List<SsoSystem> listByCondition(SsoSystem ssoSystem) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(ssoSystem);
        List<SsoSystem> list = ssoSystemService.list(queryWrapper);
        return list;
    }


    /**
     * 模糊名字查询的list查询
     *
     * @param ssoSystem
     * @return
     */
    @GetMapping("/listByVagueName")
    @ResponseBody
    public List<SsoSystem> listByVagueName(SsoSystem ssoSystem) {
        QueryWrapper queryWrapper = new QueryWrapper();
        //匹配左边,相当于从数据库右边字符开始对比,一般不会使用;更多时候是使用左边字符开始比对
        queryWrapper.likeRight("system_name", ssoSystem.getSystemName());
        List<SsoSystem> list = ssoSystemService.list(queryWrapper);
        return list;
    }


    /**
     * 使用PageHelper分页,分页参数通过自定义Page接收;
     *
     * @param page
     * @param ssoSystem
     * @return
     */
    @GetMapping("/queryByPage")
    @ResponseBody
    public PageInfo<SsoSystem> queryByPage(Page<SsoSystem> page, SsoSystem ssoSystem) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.setEntity(ssoSystem);
        //这里如果需要前端传什么字段来排序的话,需要对数据库字段进行映射,可以使用注解方式;
        queryWrapper.orderBy(true, true, "system_code");
        /**
         * PageHelper 方法使用了静态的 ThreadLocal 参数，分页参数和线程是绑定的。
         * 只要你可以保证在 PageHelper 方法调用后紧跟 MyBatis 查询方法，这就是安全的。
         */
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<SsoSystem> list = ssoSystemService.list(queryWrapper);
        PageInfo result = new PageInfo(list);
        return result;
    }

    /**
     * 通过在xml中写sql来查询,动态性最高
     *
     * @param roleCode
     * @return
     */
    @GetMapping("/getSsoSystemByRoleCode")
    @ResponseBody
    public List<SsoSystem> getSsoSystemByRoleCode(String roleCode) {
        List<SsoSystem> list = ssoSystemService.getSsoSystemByRoleCode(roleCode);
        return list;
    }


}
