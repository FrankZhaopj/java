package com.zhaopj.java.excel.setval;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 向指定excel指定单元格插入指定值
 * 注意：
 * 	单元格行和列下标都是从0开始
 */
public class SetVal {

	public static void main(String[] args) {
		String filePath = "d:\\test.xls";
		int x = 6;//列坐标(纵向),从0开始
		int y = 5;//行坐标(横向),从0开始
		String value = "测试值";
		new SetVal().test(filePath, x, y, value);
	}

	public void test(String filePath, int x, int y, String value) {
		try {
			// 创建Excel的工作书册 Workbook,对应到一个excel文档
			HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(filePath));
			HSSFSheet sheet = wb.getSheetAt(0);
			if(null == sheet) {
				sheet = wb.createSheet();
			}
			HSSFRow row = sheet.getRow((int)x);
			if(null == row) {
				row = sheet.createRow((int)x);
			}
			HSSFCell cell = row.getCell((int)y);
			if(null == cell) {
				cell = row.createCell((int)y);
			}
			cell.setCellValue(value);
			FileOutputStream os;
			os = new FileOutputStream(filePath);
			wb.write(os);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}