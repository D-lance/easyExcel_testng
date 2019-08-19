package com.demo.model.config;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

/**
 * Created by dingxinhui on 2019-07-17.
 */
public class ProblemCategoryManagement extends BaseRowModel {
    @ExcelProperty(value = "caseName",index = 0)
    private String caseName;
    @ExcelProperty(value = "url",index = 1)
    private String url;
    @ExcelProperty(value = "pageNum",index = 2)
    private String pageNum;
    @ExcelProperty(value = "pageSize",index = 3)
    private String pageSize;
    @ExcelProperty(value = "categoryName",index = 4)
    private String categoryName;
    @ExcelProperty(value = "status",index = 5)
    private String status;
    @ExcelProperty(value = "categoryId",index = 6)
    private String categoryId;
    @ExcelProperty(value = "result",index = 7)
    private String result;
    @ExcelProperty(value = "remark",index = 8)
    private String remark;

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
