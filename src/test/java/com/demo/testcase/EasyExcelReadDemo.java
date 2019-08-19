package com.demo.testcase;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

import com.demo.model.config.ProblemCategoryManagement;
import com.demo.model.config.SelfConfig;
import com.demo.utils.Assertion;
import com.demo.utils.FileUtil;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static com.demo.utils.AllureAttachment.requestBody;
import static com.demo.utils.AllureAttachment.respondBody;
import static com.demo.utils.HttpsRequest.getSend;


/**
 * Created by dingxinhui on 2019-07-17.
 */
@Epic("帮助中心")
@Feature("问题分类管理")
public class EasyExcelReadDemo {
    @Step
    @Test(description ="问题分类管理 - GET")
    public void ProblemSortDemo() throws IOException {
        // easyExcel 读取excel
        InputStream inputStream = FileUtil.getResourcesFileInputStream("/com/demo/testdata/CaseData_HelpCenter.xlsx");
        // 第一个sheet,第二行开始读
        List<Object> list = EasyExcelFactory.read(inputStream, new Sheet(1, 1, ProblemCategoryManagement.class));
        inputStream.close();

        // 定义excel读取出来的参数
        String url = ((ProblemCategoryManagement) list.get(0)).getUrl();
        System.out.println(url);
        String result = ((ProblemCategoryManagement) list.get(0)).getResult();
        System.out.println(result);

        // 测试报告展现 请求报文
        requestBody(SelfConfig.url + url,null);

        // restassured 请求
        Response response = getSend(url,null);

        // 报告响应附件
        respondBody(response.asString());

        // 断言
        Assertion.Assertion(result,response);
    }

}
