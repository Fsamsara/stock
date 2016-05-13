package com.metersbonwe.stock.pojo.sync;

/**
 * 同步库页号
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-3-28 上午10:04:34
 */
public class PageIndexBean {
    
    private int begin;
    
    private int end;

    public PageIndexBean(int begin, int end) {
        super();
        this.begin = begin;
        this.end = end;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
    @Override
    public String toString() {
        return "PageIndexBean [begin=" + begin + ", end=" + end + "]";
    }
    
}
