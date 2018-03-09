package com.springbootandredis.redisdemo.controller;


import com.springbootandredis.redisdemo.model.User;
import com.springbootandredis.redisdemo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * ${todo}...
 * ${tags}
 * @since JDK1.8
 */
@Controller
public class UserController {
    //private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

/*    @ResponseBody
    @RequestMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,produces = {"application/json;charset=UTF-8"},method= RequestMethod.POST)
    public int addUser(@RequestBody User user){
        System.out.println(user.toString());
        return userService.addUser(user);
    }*/

    @ResponseBody
    @RequestMapping("get")
    public String queryUser(Integer userId){
        System.out.println("*****userId******:"+userId);
        User user = userService.queryUser(userId);
        return  user.getUserName();
    }
/*    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", consumes = {"application/json;charset=UTF-8"},produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize){
        String name ="go go go ";
//        logger.debug("(1):打印日志信息 name:{} "+"123456879",name);
        return userService.findAllUser(pageNum,pageSize);
    }
    @ResponseBody
    @RequestMapping(value="/hi" )
    public String sayHei(){
        return "hello world";
    }
    @RequestMapping(value = "getFace",method = RequestMethod.GET)
    public String parFace(){
        return "analyze";
    }*/

}
