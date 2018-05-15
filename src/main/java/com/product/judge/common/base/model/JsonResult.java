package com.product.judge.common.base.model;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author haiyan
 * @version v0.0.1
 * @project judgeApi
 * @describe 请求结果封装类
 * @since 2018/5/10
 **/
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonResult extends HashMap<String, Object>
{
    public static final String SUCCESS_PROP = "success";

    public static final String MESSAGE_PROP = "message";

    public static final String DATA_PROP = "data";

    public static final String MESSAGE_OF_BEAN_VALIDATE = "INVALID_BEAN";

    public JsonResult()
    {
        super();
        this.setSuccess(true);
    }

    public JsonResult(Object data)
    {
        super();
        this.setSuccess(true);
        this.setData(data);
    }

    public JsonResult(Object data, int totalCount)
    {
        super();
        this.setSuccess(true);
        this.setData(data);
    }

    public JsonResult(Object data, int totalCount, int start, int limit)
    {
        super();
        this.setSuccess(true);
        this.setData(data);
    }

    public JsonResult(boolean success, String message)
    {
        super();
        this.setSuccess(success);
        this.setMessage(message);
    }

    public JsonResult(boolean success, String message, Object data)
    {
        super();
        this.setSuccess(success);
        this.setMessage(message);
        this.setData(data);
    }

    public boolean getSuccess()
    {
        return (Boolean) this.get(SUCCESS_PROP);
    }

    public JsonResult setSuccess(boolean value)
    {
        this.put(SUCCESS_PROP, value);
        return this;
    }

    public String getMessage()
    {
        return (String) this.get(MESSAGE_PROP);
    }

    public JsonResult setMessage(String value)
    {
        this.put(MESSAGE_PROP, value);
        return this;
    }

    public Object getData()
    {
        Object r = this.get(DATA_PROP);
        return r;
    }

    public JsonResult setData(Object value)
    {
        this.put(DATA_PROP, value);
        return this;
    }

    /***
     * Serialize class, except for null values, into a Json string.
     *
     * @return String
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonGenerationException
     */
    public String toJson() throws JsonGenerationException, JsonMappingException, IOException
    {
        return this.toJson(true);
    }

    /**
     * 注意在PO上增加@JsonSerialize(include=Inclusion.NON_NULL)
     *
     * @param serializeNulls
     * @return
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public String toJson(boolean serializeNulls) throws JsonGenerationException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return new String(mapper.writeValueAsBytes(this), "UTF-8");
    }

    public byte[] toJsonBytes() throws JsonGenerationException, JsonMappingException, IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(this);
    }

    @Override
    public String toString()
    {
        String str = "";
        try
        {
            str = "JsonResult [getSuccess()=" + getSuccess() + ", getMessage()=" + getMessage() + ", toJson()=" + toJson() + "]";

        }
        catch (JsonGenerationException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (JsonMappingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }

}
