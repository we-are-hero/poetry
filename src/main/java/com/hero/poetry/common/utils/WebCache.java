package com.hero.poetry.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 存放缓存
 * @param <T>   存储数据类型
 */
public class WebCache<T> {
    private static final Map<String,WebCache> map = new HashMap<>();

    public static <T> WebCache<T> getCache(String id){
        WebCache<T> webCache = null;
        try {
            webCache = (WebCache<T>)map.get(id);
        } catch (ClassCastException e) {
            e.printStackTrace();
            return null;
        }
        if (webCache == null){
            return null;
        }
        Date beginTime = webCache.getDate();
        Date endTime = new Date();
        long time1=beginTime.getTime();
        long time2=endTime.getTime();
        long result=Math.abs(time2-time1) / 1000;
        if (result > webCache.getTimeLimit()){
            remove(id);
            return null;
        }
        return webCache;
    }

    public static <T> void putCache(String id,WebCache<T> webCache){
        if (id != null && webCache != null)
            map.put(id,webCache);
    }

    public static void remove(String id){
        if (id != null)
            map.remove(id);
    }

    private final Date date;
    private Integer timeLimit = 3600;
    private T data;

    public WebCache() {
        this.date = new Date();
    }

    public WebCache<T> data(T data){
        this.data = data;
        return this;
    }

    public WebCache<T> timeLimit(Integer timeLimit){
        this.timeLimit = timeLimit;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "WebCache{" +
                "date=" + date +
                ", timeLimit=" + timeLimit +
                ", data=" + data +
                '}';
    }
}
