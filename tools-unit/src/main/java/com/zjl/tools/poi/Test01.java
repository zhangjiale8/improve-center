
package com.zjl.tools.poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test01 {
	public static void main(String[] args) {
		//1.读取Excel文档对象
        HSSFWorkbook hssfWorkbook;
		try {
			String filepath = "E:" + File.separator + "screen" + File.separator +"双色球预测汇总数据 (7).xls";

			hssfWorkbook = new HSSFWorkbook(new FileInputStream(filepath));
			//2.获取要解析的表格（第一个表格）
	        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
	        //获得最后一行的行号
	        int lastRowNum = sheet.getLastRowNum();
	        for (int i = 1; i <= lastRowNum; i++) {//遍历每一行
	            //3.获得要解析的行
	            HSSFRow row = sheet.getRow(i);
	            //4.获得每个单元格中的内容（String）
	            String stringCellValue0 = row.getCell(0).getStringCellValue();
	            String stringCellValue1 = row.getCell(1).getStringCellValue();
	            String stringCellValue2 = row.getCell(2).getStringCellValue();
	            String stringCellValue3 = row.getCell(3).getStringCellValue();
	            String stringCellValue4 = row.getCell(4).getStringCellValue();
	            System.out.println(stringCellValue0+"--"+stringCellValue1+"--"+stringCellValue2+"--"+stringCellValue3+"--"+stringCellValue4);
	        }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
}
