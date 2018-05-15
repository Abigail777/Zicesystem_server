package com.product.judge.api.business.model;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe t_user实体类
 * @since 2018/5/10
 **/
public class T_user
{
    private int usr_code;
    private String usr_id;
    private String usr_name;
    private String usr_flag;
    private String usr_passwd;

    public int getUsr_code()
    {
        return usr_code;
    }

    public void setUsr_code(int usr_code)
    {
        this.usr_code = usr_code;
    }

    public String getUsr_id()
    {
        return usr_id;
    }

    public void setUsr_id(String usr_id)
    {
        this.usr_id = usr_id;
    }

    public String getUsr_name()
    {
        return usr_name;
    }

    public void setUsr_name(String usr_name)
    {
        this.usr_name = usr_name;
    }

    public String getUsr_flag()
    {
        return usr_flag;
    }

    public void setUsr_flag(String usr_flag)
    {
        this.usr_flag = usr_flag;
    }

    public String getUsr_passwd()
    {
        return usr_passwd;
    }

    public void setUsr_passwd(String usr_passwd)
    {
        this.usr_passwd = usr_passwd;
    }
}
