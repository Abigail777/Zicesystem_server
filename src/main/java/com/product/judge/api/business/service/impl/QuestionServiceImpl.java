package com.product.judge.api.business.service.impl;

import com.product.judge.api.business.dao.PublicMethodDao;
import com.product.judge.api.business.dao.QuestionDao;
import com.product.judge.api.business.model.Questionbanktemp;
import com.product.judge.api.business.model.Sysdic;
import com.product.judge.api.business.service.QuestionService;
import com.product.judge.common.base.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 试题录入发布服务层接口实现类
 * @since 2018/5/10
 **/
@Service("questionService")
public class QuestionServiceImpl extends BaseServiceImpl implements QuestionService
{
    @Autowired
    QuestionDao questionDao;

    @Autowired
    PublicMethodDao publicMethodDao;

    /**
     * 获取当前登录人临时表中存储的数据
     *
     * @param currentUser
     * @return
     */
    @Override
    public List<Questionbanktemp> getOwnTempQuestions(String currentUser)
    {
        return questionDao.getOwnTempQuestions(currentUser);
    }

    /**
     * 使用id获取当前登录人临时表中存储的数据
     *
     * @param currentUser
     * @return
     */
    @Override
    public Questionbanktemp getOwnTempQuestionsById(String currentUser, int titalId)
    {
        return questionDao.getOwnTempQuestionsById(currentUser, titalId);
    }

    /**
     * 通过字典种类获取数据字典
     *
     * @param type
     * @return
     */
    @Override
    public List<Sysdic> getSysDicByType(String type)
    {
        return publicMethodDao.getSysDicByType(type);
    }

    /**
     * 往临时表中添加试题
     *
     * @param questionbanktemp
     */
    @Override
    public void saveNewTempQuestion(Questionbanktemp questionbanktemp, String curUserId)
    {
        questionDao.saveNewTempQuestion(questionbanktemp, curUserId);
    }

    /**
     * 更新临时表中的试题
     *
     * @param questionbanktemp
     */
    @Override
    public void updateNewTempQuestion(Questionbanktemp questionbanktemp)
    {
        questionDao.updateNewTempQuestion(questionbanktemp);
    }

    /**
     * 删除临时表中的试题
     *
     * @param id
     */
    @Override
    public void deleteNewTempQuestion(int id)
    {
        questionDao.deleteNewTempQuestion(id);
    }
}
