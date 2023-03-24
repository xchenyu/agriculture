package com.example.agriculture.common;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReturnCodeUtil {
    public static final String falseCode = "0000";//fail
    public static final String successCode = "1111";//success
    public static final String returnCode="returnCode";
    private Object data;//返回的数据
    private String message;//返回的信息
    private String code;//返回码
    private Boolean result;//true 获取数据成功  false 获取数据失败
    private int total;//总共有多少条数据

    public Object getData() {
        return data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setData(Object data) {
        if(data instanceof List){
            List list = (List)data;
            this.total = list.size();
        }
        this.data = data;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
