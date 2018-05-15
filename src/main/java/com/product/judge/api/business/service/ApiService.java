package com.product.judge.api.business.service;

import com.product.judge.common.base.service.BaseService;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe api服务层接口
 * @since 2018/5/10
 **/
public interface ApiService extends BaseService
{
    List getAllUsers();

    List getUserByName(String username);
}
