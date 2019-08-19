package com.demo.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by LiHe on 2018/8/12.10:15
 */
public class ExcelReader {


    public static Object[][] getTestData(String fileName, String sheetName) throws IOException {


        File file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;

        /**
         *  获取文件名参数的拓展名，判断是.xlsx还是xls
         */
//        String filename111 = fileName.substring(fileName.lastIndexOf("/")+1,fileName.length());



        String fileExtensionName = fileName.substring(fileName.indexOf("."));
        /**
         *   如果是.xlsx,则使用XSSFWorkbook对象进行实例化
         *   如果是.xls,则使用HSSFWorkbook对象进行实例化
         */

        if (fileExtensionName.contains(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (fileExtensionName.contains(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            System.out.println("该文件不是excel文件");
        }

        /**
         *  通过sheetName参数，生成sheet对象
         */
        if (workbook == null) {
            throw new IllegalArgumentException("workbook is null");
        }

        Sheet sheet = workbook.getSheet(sheetName);

        /***
         * 获取Excel数据文件sheet1中数据的行数，getLastRowNum方法获取数据的最后一行行号
         * getFirstRowNum方法获取数据的第一行行号，相减之后算出数据的行数
         * Excel的行号和列号都是从0开始的
         */
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        /***
         *  创建名为records的list对象来存储从Excel中读取的数据
         */

        List<Object[]> records = new ArrayList<Object[]>();

        /**
         *  使用两个for循环遍历Excel数据文件的所有数据。（除去第一行的列名称）
         */
        for (int i = 1; i <= rowCount; i++) {
            Row row = sheet.getRow(i);

            /**
             *  声明一个数组files，用来存储excel数据文件每行数据，数组的大小用getLastCellNum方法来进行动态声明。
             */

            String files[] = new String[row.getLastCellNum()];


            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell =row.getCell(j);
                if (cell == null){
                    continue;
                }
                cell.setCellType(CellType.STRING);
                files[j] = cell.getStringCellValue();
            }
            records.add(files);
        }

        Object[][] results = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            results[i] = records.get(i);
        }

        return results;

    }


}
