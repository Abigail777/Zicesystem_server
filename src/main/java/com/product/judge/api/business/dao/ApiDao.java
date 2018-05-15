package com.product.judge.api.business.dao;

import com.product.judge.common.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe api持久层
 * @since 2018/5/10
 **/
@Repository("apiDao")
public class ApiDao extends BaseDao
{
    public List getAllUsersBySql()
    {
        String sql = "select usr_code,usr_name,usr_flag from t_user";
        return getjBaseDao().queryForList(sql);
    }

    public List getUserByName(String username)
    {
        String sql = "select usr_code,usr_name,usr_flag from t_user where usr_name = ?";
        return getjBaseDao().queryForList(sql, new String[]{username});
    }
}
