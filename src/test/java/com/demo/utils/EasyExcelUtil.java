package com.demo.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.demo.model.config.ProblemCategoryManagement;
import groovy.util.logging.Slf4j;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dingxinhui on 2019-07-17.
 */
@Slf4j
@lombok.extern.slf4j.Slf4j
public class EasyExcelUtil {
    public  List<Object>  EasyExcelUtil(String filename, int sheetNo, int headLineMun,Class ReadModel) throws IOException {
        InputStream inputStream = FileUtil.getResourcesFileInputStream(filename);
        List<Object>  list = EasyExcelFactory.read(inputStream, new Sheet(sheetNo, headLineMun, ReadModel));
        inputStream.close();

        return list;

    }

    @Test
    public void test() throws IOException {
        List<Object> list= EasyExcelUtil("com/demo/testdata/CaseData_HelpCenter.xlsx",4,1, ProblemCategoryManagement.class);

        String url = ((ProblemCategoryManagement) list.get(0)).getUrl();
        String result = ((ProblemCategoryManagement) list.get(0)).getResult();

        System.out.println(url);
        System.out.println(result);
    }

}
