package com.hero.poetry.entity.dto;

import java.util.Collections;
import java.util.List;

public class PageDTO<T> {
    private long total = 0;

    private List<T> records = Collections.emptyList();

    private Integer current;

    private Integer limit;

    public PageDTO() {
    }

    public PageDTO(Integer current, Integer limit) {
        this.current = current;
        this.limit = limit;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "total=" + total +
                ", records=" + records +
                ", current=" + current +
                ", limit=" + limit +
                '}';
    }
}
