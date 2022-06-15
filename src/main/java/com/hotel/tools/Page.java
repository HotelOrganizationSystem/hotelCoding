package com.hotel.tools;

import java.util.List;
/**
 * 为实体类分页
 *
 * @author ling
 * @since 2021-07-14 10:10:08
 */
public class Page <E>{
    private int code;
    private  String msg;
    private int count;
    private List<E> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }


}
