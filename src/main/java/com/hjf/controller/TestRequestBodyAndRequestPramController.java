package com.hjf.controller;

import com.hjf.entity.TestRequetBody;
import com.hjf.utils.json.JacksonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;



@Controller
@RequestMapping(value = "/test")
public class TestRequestBodyAndRequestPramController {


    //日志使用门面slf4j引入日志,不要引入logback或Log4j
    private final static Logger logger = LoggerFactory.getLogger(TestRequestBodyAndRequestPramController.class);
    /**
     * postman请求类型为=application/json,方式为get,json=[{"as":"sdf"}]
     * 也是可以得到请求结果的,注意前端json格式和方法接受的类型需要匹配,可以自由调正;如这里要[]包一次
     * 也可以不包,但要前端和后端一致,不然就会转换错误
     *结果:@RequestBody可以获取到请求体的数据,它只能获取到httpEntity的数据,但不能得到url?号方式的数据
     */
    @ResponseBody
    @GetMapping("/all2")
    public Object findAllUser2(@RequestBody List<Map<String,String>> lists){
        for (Map<String,String> maps:  lists) {
            maps.forEach((k,v)-> System.out.println(k+":"+v));
        }
        return null;
    }


    /**
     *
     *目的:postman请求类型为=application/json,方式为get,json={"as":"sdf"}
     * 和上面的区别就是接受参数的类型不一样一个list,一个map;只要前后端一致就ok
     */
    @ResponseBody
    @PostMapping("/all3")
    public Object findAllUser3(@RequestBody Map<String,String> maps){
        maps.forEach((k,v)-> System.out.println(k+":"+v));
        return null;
    }



    /**
     * 目的:postman请求类型为=application/json,方式为get,json={"userName":"df","date":"2001-01-02 17:55:22"}
     * 是否可以自动映射为对象
     * 结果:@RequestBody可以获取到请求体的数据,它只能获取到httpEntity的数据,但不能得到url?号方式的数据
     * 请求和返回时都请通过json格式交换数据
     */
    @ResponseBody
    @GetMapping("/all4")
    public String findAllUser4(@RequestBody TestRequetBody user) throws Exception {
        logger.info("传入参数:{},{}",user.getUserName(),user.getDate());
        user.setDate(new Date());
        return JacksonUtils.obj2json(user);
    }


    /**
     * 和上面就一个@RequestParam和@RequestBody区别,测试看看
     * postman请求类型为=application/json,方式为get,json={"userName":"df","date":"2001-01-02 17:55:22"}
     * 是否可以自动映射为对象
     * 测试结果:不能被映射成功,因为@RequestParam 不能跟一个对象,只能是修饰具体的一个值;
     * 所以要么你就不要用@RequestParam 修饰就可以自动封装
     *
     */
    @ResponseBody
    @GetMapping("/all5")
    public String findAllUser5(@RequestParam TestRequetBody user) throws Exception {
        logger.info("传入参数:{},{}",user.getUserName(),user.getDate());
        user.setDate(new Date());
        return JacksonUtils.obj2json(user);
    }

    /**
     * postman请求类型为=application/json,方式为get,json={"userName":"df","date":"2001-01-02 17:55:22"}
     * url=http://127.0.0.1:8081/test/all6?userName=23
     * 结果:json中的数据收不到,url的数据可以隐射到实体中
     */

    @ResponseBody
    @GetMapping("/all6")
    public String findAllUser6(TestRequetBody user) throws Exception {
        logger.info("传入参数:{},{}",user.getUserName(),user.getDate());
        user.setDate(new Date());
        return JacksonUtils.obj2json(user);
    }





}
