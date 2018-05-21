package com.product.judge.api.business.model;

/**
 * 试题批次信息
 */
public class Batchinfo
{
    private String batchid;//批次编号
    private String ownid;//出题人
    private String descinfo;//试题描述信息
    private Long buycount;//购买次数

    public String getDescinfo()
    {
        return descinfo;
    }

    public void setDescinfo(String descinfo)
    {
        this.descinfo = descinfo;
    }

    public Long getBuycount()
    {
        return buycount;
    }

    public void setBuycount(Long buycount)
    {
        this.buycount = buycount;
    }

    public String getBatchid()
    {
        return batchid;
    }

    public void setBatchid(String batchid)
    {
        this.batchid = batchid;
    }

    public String getOwnid()
    {
        return ownid;
    }

    public void setOwnid(String ownid)
    {
        this.ownid = ownid;
    }
}
