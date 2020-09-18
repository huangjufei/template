package com.hjf.controller;


import com.hjf.entity.SsoSystem;
import com.hjf.service.SsoSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 * 系统表 前端控制器
 * </p>
 *
 * @author 黄举飞
 * @since 2020-09-17
 */
@Controller
@RequestMapping("/ssoSystem")
public class SsoSystemController {


    @Autowired
    private SsoSystemService ssoSystemService;

    @GetMapping("/list")
    @ResponseBody
    public List<SsoSystem> list(){


        List<SsoSystem> list = ssoSystemService.list();
        return list;
    }


}
