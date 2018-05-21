package com.product.judge.api.business.service;

import com.product.judge.api.business.model.Questionbanktemp;
import com.product.judge.api.business.model.Sysdic;
import com.product.judge.common.base.service.BaseService;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 试题录入发布服务层接口
 * @since 2018/5/10
 **/
public interface QuestionService extends BaseService
{

    List<Questionbanktemp> getOwnTempQuestions(String currentUser);

    Questionbanktemp getOwnTempQuestionsById(String currentUser, int titalId);

    List<Sysdic> getSysDicByType(String type);

    void saveNewTempQuestion(Questionbanktemp questionbanktemp, String curUserId);

    void updateNewTempQuestion(Questionbanktemp questionbanktemp);

    void deleteNewTempQuestion(int id);
}
