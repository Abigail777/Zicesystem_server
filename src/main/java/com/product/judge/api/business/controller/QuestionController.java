package com.product.judge.api.business.controller;

import com.product.judge.api.business.model.Questionbanktemp;
import com.product.judge.api.business.model.Sysdic;
import com.product.judge.api.business.service.QuestionService;
import com.product.judge.common.constant.GlobalConstant;
import com.product.judge.common.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 试题录入
 * @since 2018/5/20
 **/
@Controller
@RequestMapping("/questions")
public class QuestionController
{
    @Autowired
    QuestionService questionService;

    /**
     * 查询临时表中所有的试题信息
     *
     * @param request
     * @param model
     * @return
     */
    @GetMapping("/tempQuestions")
    public String list(HttpServletRequest request, Model model)
    {
        List<Questionbanktemp> list = questionService.getOwnTempQuestions(SessionUtil.getCurrentUser(request));
        model.addAttribute("tempQuestions", list);
        return "question/questionlist";
    }

    /**
     * 跳转到试题添加界面
     *
     * @param model
     * @return
     */
    @GetMapping("/addQuestions")
    public String toAddPage(Model model)
    {
        List<Sysdic> sysdics = questionService.getSysDicByType(GlobalConstant.DIC_QUESTION_TYPE);
        model.addAttribute("sysdics", sysdics);
        return "question/questionadd";
    }

    /**
     * 往临时表中保存要添加的试题
     *
     * @param questionbanktemp
     * @return
     */
    @PostMapping("/tempQuestion")
    public String addQuestionRecord(HttpServletRequest request, Questionbanktemp questionbanktemp)
    {
        questionService.saveNewTempQuestion(questionbanktemp, SessionUtil.getCurrentUser(request));
        return "redirect:/questions/tempQuestions";
    }

    /**
     * 跳转到临时表试题修改界面
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/tempQuestion/{id}")
    public String toEditPage(HttpServletRequest request, @PathVariable("id") Integer id, Model model)
    {
        Questionbanktemp questionbanktemp = questionService.getOwnTempQuestionsById(SessionUtil.getCurrentUser(request), id);
        model.addAttribute("question", questionbanktemp);
        List<Sysdic> sysdics = questionService.getSysDicByType(GlobalConstant.DIC_QUESTION_TYPE);
        model.addAttribute("sysdics", sysdics);
        return "question/questionadd";
    }

    /**
     * 临时表中的试题提交修改
     *
     * @param questionbanktemp
     * @return
     */
    @PutMapping("/tempQuestion")
    public String updateTempQuestion(HttpServletRequest request, Questionbanktemp questionbanktemp)
    {
        questionService.updateNewTempQuestion(questionbanktemp);
        return "redirect:/questions/tempQuestions";
    }

    /**
     * 删除临时中的试题
     *
     * @param id
     * @return
     */
    @DeleteMapping("/tempQuestion/{id}")
    public String deleteTempQuestion(@PathVariable("id") Integer id)
    {
        questionService.deleteNewTempQuestion(id);
        return "redirect:/questions/tempQuestions";
    }

    /**
     * 试题发布
     *
     * @return
     */
    @PostMapping("/appearQuestions")
    public String appearQuestions(HttpServletRequest request, @RequestParam Map map)
    {
        System.out.println(map);
        return "redirect:/questions/tempQuestions";
    }
}
