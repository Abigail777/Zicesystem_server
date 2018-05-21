package com.product.judge.api.business.dao;

import com.product.judge.api.business.model.Questionbanktemp;
import com.product.judge.common.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 试题录入发布持久层
 * @since 2018/5/10
 **/
@Repository("questionDao")
public class QuestionDao extends BaseDao
{

    /**
     * 使用ownId获取临时表中的试题
     *
     * @param currentUser
     * @return
     */
    public List<Questionbanktemp> getOwnTempQuestions(String currentUser)
    {
        String sql = "select * from Questionbanktemp where ownId = ? ";
        return getjBaseDao().queryForModelList(sql, new String[]{currentUser}, Questionbanktemp.class);
    }

    /**
     * 使用id获取当前登录人临时表中存储的数据
     *
     * @param currentUser
     * @param titalId
     * @return
     */
    public Questionbanktemp getOwnTempQuestionsById(String currentUser, int titalId)
    {
        String sql = "select * from Questionbanktemp where ownId = ? and titleid = ? ";
        return getjBaseDao().queryForModel(sql, new Object[]{currentUser, titalId}, Questionbanktemp.class);
    }

    /**
     * 往临时表中添加试题
     *
     * @param q
     * @param userId
     */
    public void saveNewTempQuestion(Questionbanktemp q, String userId)
    {
        Object[] field = {q.getClassid(), q.getQuestion(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4(), q.getAnswer(), q.getExplainmsg(), userId};
        StringBuffer sql = new StringBuffer("\n");
        sql.append("insert into Questionbanktemp(classid,question,opt1,opt2,opt3,opt4,answer,explainmsg,ownid)");
        sql.append("values(?,?,?,?,?,?,?,?,?)");
        getjBaseDao().update(sql.toString(), field);
    }

    /**
     * 更新临时表中的试题
     *
     * @param q
     */
    public void updateNewTempQuestion(Questionbanktemp q)
    {
        Object[] field = {q.getClassid(), q.getQuestion(), q.getOpt1(), q.getOpt2(), q.getOpt3(), q.getOpt4(), q.getAnswer(), q.getExplainmsg(), q.getTitleid()};
        StringBuffer sql = new StringBuffer("\n");
        sql.append("update Questionbanktemp set \n");
        sql.append("    classid     = ?,\n");
        sql.append("    question    = ?,\n");
        sql.append("    opt1        = ?,\n");
        sql.append("    opt2        = ?,\n");
        sql.append("    opt3        = ?,\n");
        sql.append("    opt4        = ?,\n");
        sql.append("    answer      = ?,\n");
        sql.append("    explainmsg  = ? \n");
        sql.append("where  titleid  = ?");
        getjBaseDao().update(sql.toString(), field);
    }

    /**
     * 删除临时表中的试题
     *
     * @param id
     */
    public void deleteNewTempQuestion(int id)
    {
        String sql = "delete from Questionbanktemp where titleid = ? ";
        getjBaseDao().update(sql, new Object[]{id});
    }
}
