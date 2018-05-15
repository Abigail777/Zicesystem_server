package com.product.judge.api.business.controller;

import com.product.judge.api.business.service.ApiService;
import com.product.judge.common.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe api数据接口
 * @since 2018/5/10
 **/
@Controller
@RequestMapping
public class ApiController
{
    @Autowired
    ApiService apiService;

    @RequestMapping(value = "/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/num")
    @ResponseBody
    int num()
    {
        return 404;
    }

    @RequestMapping("/getAllusers")
    @ResponseBody
    List users()
    {
        return apiService.getAllUsers();
    }

    @RequestMapping("/getUser")
    @ResponseBody
    List getUsers(String username)
    {
        if (StringUtil.isNullString(username))
        {
            return apiService.getAllUsers();
        }
        else
        {
            return apiService.getUserByName(username);
        }
    }
}
