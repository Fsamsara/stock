package com.metersbonwe.stock.pojo.sync;

import java.io.Serializable;

/**
 * 分页相关BEAN
 * 
 * @author 张瑞雨 zhangry@metersbonwe.com
 * @date 2016-3-28 上午10:04:17
 */
public class PageBean implements Serializable {

    private static final long serialVersionUID = 5770059932899651694L;

    private int               maxPageNo;

    private int               maxSize;

    private int               allCount;

    private volatile int      currentPageNo    = 0;

    public PageBean(int maxSize, int allCount) {
        this.maxSize = maxSize;
        this.allCount = allCount;
        /* 最大页码 */
        maxPageNo = getPageNo(allCount, maxSize);
    }

    public int getPageNo(int allCount, int size) {
        return allCount % size == 0 ? allCount / size : allCount / size + 1;
    }

    public PageIndexBean next() {
        int begin = currentPageNo * maxSize;
        int end = begin + maxSize;
        end = end > allCount ? allCount : end;
        currentPageNo++;
        return new PageIndexBean(begin, end);
    }

    public boolean hasNext() {
        return currentPageNo < maxPageNo;
    }

    public int getMaxPageNo() {
        return maxPageNo;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public int getAllCount() {
        return allCount;
    }

    public int getCurrentPageNo() {
        return currentPageNo;
    }

    @Override
    public String toString() {
        return "PageBean [maxPageNo=" + maxPageNo + ", maxSize=" + maxSize + ", currentPageNo=" + currentPageNo + "]";
    }

}
