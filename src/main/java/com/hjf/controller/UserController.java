package com.hjf.controller;

import com.hjf.entity.UserDomain;
import com.hjf.service.UserService;
import com.hjf.utils.Result;
import com.hjf.utils.ResultUtil;
import com.hjf.utils.properties.BoyProperties;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
//swagger配置
@Api(value = "测试ControllerTest", tags = {"测试访问接口"})
public class UserController {
    //日志使用门面slf4j引入日志,不要引入logback或Log4j
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BoyProperties boyProperties;


    @ResponseBody
    @PostMapping("/add")
    @ApiOperation(value = "添加测试数据")
    @ApiResponses(value = {
            @ApiResponse(code = 1000, message = "成功"),
            @ApiResponse(code = 1001, message = "失败"),
            @ApiResponse(code = 1002, message = "缺少参数",
                    response = UserDomain.class)
    })
    public Result<Integer> addUser(@Valid UserDomain user, BindingResult bindingResult,HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        String userName = request.getParameter("userName");
        return ResultUtil.success(userService.addUser(user));
    }




    @ResponseBody
    @GetMapping("/all")
    @ApiOperation(value = "查询全部")
    public Object findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize){
        logger.info("传入参数:{},{}",pageNum,pageSize);
        logger.info(boyProperties.toString());//读取配置文件
        return userService.findAllUser(pageNum,pageSize);
    }


    /**
     * 功能:多文件接收服务端,可以通过head来传递参数,但没有控制文件大小等,后期;很好加
     * 但这个代码只是调通,里面可能出现的null或异常都没有判断;使用时在优化
     *
     */
    @PostMapping("/post")
    public void processUpload(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String saveFolder = "D:\\aa";
        String tempFolder = "D:\\temp";
        String utf8 = "UTF-8";
        File uploadFile = new File(saveFolder);
        if (!uploadFile.exists()) {
            uploadFile.mkdirs();
        }
        request.setCharacterEncoding(utf8);
        response.setCharacterEncoding(utf8);
        System.out.println(request.getParameter("userName"));
        System.out.println(request.getHeader("userName"));
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        System.out.println("总大小:"+multipartRequest.getContentLengthLong());
        Map<String, MultipartFile> map = multipartRequest.getFileMap();
        for ( Map.Entry<String, MultipartFile> m : map.entrySet()){
            m.getValue().transferTo(new File(saveFolder, m.getKey()));
            System.out.println("控制文件大小:"+m.getValue().getBytes().length);
        }
        response.addHeader("token", "hello");
    }





}
