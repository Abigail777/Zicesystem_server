package com.product.judge.api.business.dao;

import com.product.judge.common.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.Map;

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
    /**
     * 校验登录信息
     *
     * @param usr_id
     * @param usr_passwd
     * @return
     */
    public Map checkLoginInfo(String usr_id, String usr_passwd)
    {
        String sql = "select count(1) flag from sysuser where usr_id = ? and usr_passwd = ?";
        return getjBaseDao().queryForMap(sql, new String[]{usr_id, usr_passwd});
    }
}
