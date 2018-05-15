package com.product.judge.common.base.dao;

import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 持久层基类
 * @since 2018/5/10
 **/
@Repository("baseDao")
@Scope("prototype")
public class BaseDao
{
    @Resource
    private JBaseDao jBaseDao;

    public JBaseDao getjBaseDao()
    {
        return jBaseDao;
    }

    public void setjBaseDao(JBaseDao jBaseDao)
    {
        this.jBaseDao = jBaseDao;
    }

    /**
     * 子类中调用可覆盖jBaseDao中的jdbcTemplate
     *
     * @param jdbcTemplate
     */
    protected void setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.getjBaseDao().setJdbcTemplate(jdbcTemplate);
    }


}
