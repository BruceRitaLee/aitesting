package com.huicewang.aitesting.common;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import lombok.Setter;

import  java.util.List;

@Getter
@Setter
public class CommonPage<T>  {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;
    public static <T> CommonPage<T> restResult(Page<T> pageResult){
        CommonPage<T> page =new CommonPage();
        page.setPageNum((int) pageResult.getCurrent());
        page.setPageSize((int) pageResult.getSize());
        page.setTotalPage((int) pageResult.getPages());
        page.setTotal(pageResult.getTotal());
        page.setList(pageResult.getRecords());
        return  page;
    }

    private void setList(List<T> records) {
        this.list=records;
    }

    private void setTotal(long total) {
        this.total=total;
    }

    private void setTotalPage(int pages) {
        this.totalPage=pages;
    }

    private void setPageSize(int size) {
        this.pageSize=size;
    }

    private void setPageNum(int current) {
        this.pageNum = current;
    }
}
