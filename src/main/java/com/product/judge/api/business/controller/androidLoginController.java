package com.product.judge.api.business.controller;


import com.product.judge.common.base.dao.JBaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class androidLoginController
{
    @Autowired
    JBaseDao jdbcTemplate;

    @PostMapping("/checkLogin")
    public Map check(String usr_id, String usr_passwd)
    {
        String sql = "select count(1) flag from t_user where usr_id = ? and usr_passwd = ?";
        return jdbcTemplate.queryForMap(sql, new String[]{usr_id, usr_passwd});
    }


}
