package com.zhaopj.java.excel.export;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * 导出excel(2003版本)
 * @author Administrator
 *
 */
public class ExportExcel_1 {

	public static void main(String[] args) {
		//导出excel
		HSSFWorkbook wb = export();
//		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-disposition", "attachment;filename=clickStatistics"+dateStr+".xls");
//		OutputStream ouputStream = response.getOutputStream();
//		wb.write(ouputStream);
//		ouputStream.flush();
//		ouputStream.close();
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 菜单点击量导出excel
	 */
	public static HSSFWorkbook export() {
		//获取所有的菜单名称
		List<Map<String, Object>> listPageTitle = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listMenuTitle = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listMenuTitleChange = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listContent = new ArrayList<Map<String, Object>>();
		//创建excel
		HSSFWorkbook wb = new HSSFWorkbook();
		//判空
		if(null != listContent && listContent.size() > 0){
			//设置excel sheet名称
			String sheetName = "";
			String sum1 = "合计";
			//根据type判断导出类型来创建合计列标题
			sheetName = "菜单点击量统计表";
			//创建样式
			HSSFCellStyle styleTitle = wb.createCellStyle();//居中对其
			HSSFCellStyle styleCenter = wb.createCellStyle();//居中对其
			HSSFCellStyle styleCenterBold = wb.createCellStyle();//居中粗体
			HSSFCellStyle styleCenterRedBold = wb.createCellStyle();//居中红色粗体
			HSSFCellStyle styleRight = wb.createCellStyle();//右对齐
			HSSFCellStyle styleRightRedBold = wb.createCellStyle();//右对齐红色粗体
			//设置对齐方式
			styleTitle.setAlignment(HorizontalAlignment.CENTER);
			styleCenter.setAlignment(HorizontalAlignment.CENTER);
			styleCenterBold.setAlignment(HorizontalAlignment.CENTER);
			styleCenterBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//			styleCenterBold.setFillForegroundColor(HSSFColor.YELLOW.index);
//			styleCenterBold.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
//			styleCenterBold.setFillBackgroundColor(HSSFColor.YELLOW.index); 
			styleCenterRedBold.setAlignment(HorizontalAlignment.CENTER);
			styleRight.setAlignment(HorizontalAlignment.RIGHT);
			styleRightRedBold.setAlignment(HorizontalAlignment.RIGHT);
			//设置字体样式及颜色
			Font fontBold = wb.createFont();  
			Font fontRedBold = wb.createFont();  
			Font fontTitle = wb.createFont();  
			fontBold.setBold(true);
			fontRedBold.setColor(HSSFColor.RED.index);  
			fontRedBold.setBold(true);
			fontTitle.setBold(true);
			fontTitle.setFontHeight((short) 280);
			//设置样式
			styleTitle.setFont(fontTitle);
			styleCenterBold.setFont(fontBold); 
			styleCenterRedBold.setFont(fontRedBold); 
			styleRightRedBold.setFont(fontRedBold);
			//分享列数
			int fxColNum = 0;
			//如果存在数据则创建excel
			if(null != listMenuTitle && null != listContent && listMenuTitle.size() > 0 && listContent.size() > 0){
				
				//查询所有的菜单名称，封装成数组
				String[] excelHeader = new String[listMenuTitle.size() + 2];
				String[] excelHeaderChange = new String[listMenuTitleChange.size() + 2];
				excelHeader[0] = null;
				excelHeaderChange[0] = null;
				String s1 = "", s2 = "";
				for(int i = 0; i< listMenuTitle.size(); i++){
					s1 = listMenuTitle.get(i).get("MENU_NAME") + "";
					s2 = listMenuTitleChange.get(i).get("MENU_NAME") + "";
					excelHeader[i+1] = s1;
					excelHeaderChange[i+1] = s2;
				}
				excelHeader[excelHeader.length - 1] = sum1;
				//创建sheet
				HSSFSheet sheet = wb.createSheet(sheetName);
				//创建行
				HSSFRow row = sheet.createRow((int) 0);
				//创建表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
				sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, excelHeader.length - 1)); 
				//设置表头
				HSSFCell cellTitle = row.createCell(0);
				cellTitle.setCellValue(sheetName);
				cellTitle.setCellStyle(styleTitle);
				//创建行：循环创建Page标题
				if(null!= listPageTitle && listPageTitle.size() > 0){
					row = sheet.createRow((int) 1);

					//业务办理类
					int menuNum = 0, colStartNum = 1, colEndtNum = 0;
					for (int i = 0; i < listPageTitle.size(); i++) {
						colStartNum = colStartNum + menuNum;//起始列号
						menuNum = Integer.valueOf(listPageTitle.get(i).get("MENU_NUM")+"").intValue();//菜单数
						colEndtNum = colEndtNum + menuNum;//终止列号
						//创建pageName表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
						if(colEndtNum > colStartNum){
							sheet.addMergedRegion(new CellRangeAddress(1, 1, colStartNum, colEndtNum));
						} 
						//创建单元格
						HSSFCell cell = row.createCell(colStartNum);
						//创建数据
						cell.setCellValue(listPageTitle.get(i).get("PAGE_NAME")+"");
						//设置样式
						cell.setCellStyle(styleCenterBold);
					}
					//创建pageName表头合并列，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
					sheet.addMergedRegion(new CellRangeAddress(1, 2, excelHeader.length - 1, excelHeader.length - 1));
					//创建单元格
					HSSFCell cell = row.createCell(colEndtNum + 1);
					//创建数据;根据type判断导出类型来创建合计列标题
					cell.setCellValue(sum1);
					//设置样式
					cell.setCellStyle(styleCenterBold);
				}
				//循环创建行：数据内容
				for (int i = 0; i < listContent.size(); i++) {
					HSSFCell cell = null;
					row = sheet.createRow(i);
					Map<String, Object> map = listContent.get(i);
					//通过标题获取对应值
					for (int j = 0; j < excelHeader.length; j++) {
						cell = row.createCell(j);
						if(j == 0){
							cell.setCellValue(map.get("AREA_NAME")+"");
							cell.setCellStyle(styleCenterBold);
						}else{
							cell.setCellValue(map.get("'"+excelHeader[j]+"'")+"");
							if(j == excelHeader.length - 1){
								cell.setCellStyle(styleRightRedBold);
							}else{
								cell.setCellStyle(styleRight);
							}
						}
					}
				}
			}
		}
		return wb;
	}
	
	/**
	 * 消息信息推送导出excel
	 */
	public static HSSFWorkbook msgExport() {
		//获取所有的菜单名称
		List<Map<String, Object>> listTitle = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> listContent = new ArrayList<Map<String, Object>>();
		//创建excel
		HSSFWorkbook wb = new HSSFWorkbook();
		//判空
		if(null != listTitle && null != listContent && listTitle.size() > 0 && listContent.size() > 0){
			//设置excel sheet名称
			String sheetName = "";
			String sum1 = "合计";
			sheetName = "业务消息推送统计表";
			//创建样式
			HSSFCellStyle styleTitle = wb.createCellStyle();//居中对其
			HSSFCellStyle styleCenter = wb.createCellStyle();//居中对其
			HSSFCellStyle styleCenterBold = wb.createCellStyle();//居中粗体
			HSSFCellStyle styleCenterRedBold = wb.createCellStyle();//居中红色粗体
			HSSFCellStyle styleRight = wb.createCellStyle();//右对齐
			HSSFCellStyle styleRightRedBold = wb.createCellStyle();//右对齐红色粗体
			//设置对齐方式
			styleTitle.setAlignment(HorizontalAlignment.CENTER);
			styleCenter.setAlignment(HorizontalAlignment.CENTER);
			styleCenterBold.setAlignment(HorizontalAlignment.CENTER);
			styleCenterBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
//			styleCenterBold.setFillForegroundColor(HSSFColor.YELLOW.index);
//			styleCenterBold.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
//			styleCenterBold.setFillBackgroundColor(HSSFColor.YELLOW.index); 
			styleCenterRedBold.setAlignment(HorizontalAlignment.CENTER);
			styleRight.setAlignment(HorizontalAlignment.RIGHT);
			styleRightRedBold.setAlignment(HorizontalAlignment.RIGHT);
			//设置字体样式及颜色
			Font fontBold = wb.createFont();  
			Font fontRedBold = wb.createFont();  
			Font fontTitle = wb.createFont();  
			fontBold.setBold(true);
			fontRedBold.setColor(HSSFColor.RED.index);  
			fontRedBold.setBold(true);
			fontTitle.setBold(true);
			fontTitle.setFontHeight((short) 280);
			//设置样式
			styleTitle.setFont(fontTitle);
			styleCenterBold.setFont(fontBold); 
			styleCenterRedBold.setFont(fontRedBold); 
			styleRightRedBold.setFont(fontRedBold);
			//如果存在数据则创建excel
			if(null != listTitle && null != listContent && listTitle.size() > 0 && listContent.size() > 0){
				//查询所有的菜单名称，封装成数组
				String[] excelHeader = new String[listTitle.size() + 2];
				excelHeader[0] = null;
				String s1 = "";
				for(int i = 0; i< listTitle.size(); i++){
					s1 = listTitle.get(i).get("MSG_BUS_NAME") + "";
					excelHeader[i+1] = s1;
				}
				excelHeader[excelHeader.length - 1] = sum1;
				//创建sheet
				HSSFSheet sheet = wb.createSheet(sheetName);
				//创建行
				HSSFRow row = sheet.createRow((int) 0);
				//创建表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelHeader.length - 1));
				//设置表头
				HSSFCell cellTitle = row.createCell(0);
				cellTitle.setCellValue(sheetName);
				cellTitle.setCellStyle(styleTitle);
				//开始创建列标题
				row = sheet.createRow((int) 1);
				//循环写列标题
				String v = "";
				for (int i = 0; i < excelHeader.length; i++) {
					//创建单元格
					HSSFCell cell = row.createCell(i);
					v = excelHeader[i];
					//创建数据
					cell.setCellValue(v);
		            //设置样式
		            cell.setCellStyle(styleCenterBold);
		            //设置列宽
					sheet.autoSizeColumn(i);
					if(null != excelHeader[i] && excelHeader[i].length() > 0){
						sheet.setColumnWidth(i, 3000);
					}else{
						sheet.setColumnWidth(i, 1800);
					}
				}
				//循环创建行：数据内容
				for (int i = 0; i < listContent.size(); i++) {
					HSSFCell cell = null;
					row = sheet.createRow(i + 2);
					Map<String, Object> map = listContent.get(i);
					//通过标题获取对应值
					for (int j = 0; j < excelHeader.length; j++) {
						cell = row.createCell(j);
						if(j == 0){
							cell.setCellValue(map.get("AREA_NAME")+"");
							cell.setCellStyle(styleCenterBold);
						}else if(j == excelHeader.length - 1){
							cell.setCellValue(map.get("合计")+"");
							cell.setCellStyle(styleRightRedBold);
						}else{
							v = map.get("'"+excelHeader[j]+"'")+"";
							cell.setCellValue(v);
							//最后一行合计，全部显示红色粗体
							if(i == listContent.size() - 1){
								cell.setCellStyle(styleRightRedBold);
							}else{
								cell.setCellStyle(styleRight);
							}
						}
					}
				}
			}
		}
		return wb;
	}

	
/**
 * 业务功能原码
 */
//html
//	<input type="button" name="button" onclick="javascript:msgExportExcel(1);" value="导出">
//JS
//	/**
//	 * 消息推送统计结果导出excel
//	 * type:
//	 * 	1:业务消息推送统计
//	 * 	2:业务环节消息推送统计
//	 */
//	function msgExportExcel(type){
//		var total_type = $("#total_type option:selected").val();// 统计类别编码
//		var menu_type = $("#menu_type option:selected").val();// 功能类别编码
//		var startTime = $("#startTime").val();//开始时间
//		var endTime = $("#endTime").val();//结束时间
//		location.href="/UapJava/excel/msgExport?type="+type+"&menu_type="+menu_type+"&total_type="+total_type+"&startTime="+startTime+"&endTime="+endTime;   
//	}
//Controller
//	/**
//	 * 导出excel
//	 */
//	@RequestMapping(value = "/excel/export")
//	public void exportExcel(String type, String menu_type, String total_type, String startTime, String endTime, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String pageIndex = request.getParameter("pageIndex");//当前页
//		pageIndex = (StringUtils.isNotBlank(pageIndex)) ? pageIndex : "1";
//		PageJS<QueryJiangsuClickData> page = new PageJS<QueryJiangsuClickData>();
//		page.setNo(Integer.parseInt(pageIndex));
//		QueryJIiangsuClickinfo queryInfo = new QueryJIiangsuClickinfo();
//		queryInfo.setMenu_type(menu_type);
//		queryInfo.setTotal_type(total_type);
//		queryInfo.setStartTime(startTime);
//		queryInfo.setEndTime(endTime);
//		queryInfo.setStart(page.getStart());
//		queryInfo.setEnd(page.getEnd());
//		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
//		String dateStr = sf.format(new Date());
//		//导出excel
//		HSSFWorkbook wb = exportService.export(type, queryInfo);
//		response.setContentType("application/vnd.ms-excel");
//		response.setHeader("Content-disposition", "attachment;filename=clickStatistics"+dateStr+".xls");
//		OutputStream ouputStream = response.getOutputStream();
//		wb.write(ouputStream);
//		ouputStream.flush();
//		ouputStream.close();
//	}
//service
//	/**
//	 * 菜单点击量导出excel
//	 */
//	@Override
//	public HSSFWorkbook export(String type, QueryJIiangsuClickinfo queryInfo) {
//		int menuTitleRowNum = 0;
//		int titleRowCount = 0;
//		String menuType = queryInfo.getMenu_type();
//		if(null != menuType && ("01".equalsIgnoreCase(menuType) || "02".equalsIgnoreCase(menuType))){
//			menuTitleRowNum = 1;
//			titleRowCount = 2;
//		}else {
//			menuTitleRowNum = 2;
//			titleRowCount = 3;
//		}
//		//获取所有的菜单名称
//		List<Map<String, Object>> listPageTitle = getAllPageName(queryInfo);
//		List<Map<String, Object>> listMenuTitle = getAllMenuName(type, queryInfo);
//		List<Map<String, Object>> listMenuTitleChange = getAllMenuNameChange(type, queryInfo);
//		List<Map<String, Object>> listContent = null;
//		List<Map<String, Object>> listSum = null;
//		//根据type判断导出类型并获取统计明细及合计
//		if("1".equals(type)){
//			listContent = iQueryJiangsuClickService.getNumList(queryInfo);
//			listSum = iQueryJiangsuClickService.getNumListAll(queryInfo);
//		}else if("2".equals(type)){
//			listContent = iQueryJiangsuUserClickService.getNumList(queryInfo);
//			listSum = iQueryJiangsuUserClickService.getNumListAll(queryInfo);
//		}
//		//创建excel
//		HSSFWorkbook wb = new HSSFWorkbook();
//		//判空
//		if(null != listContent && null != listSum && listContent.size() > 0 && listSum.size() > 0){
//			//设置excel sheet名称
//			String sheetName = "";
//			String sum1 = "合计";
//			String sum2 = "合计(去重)";
//			//根据type判断导出类型来创建合计列标题
//			if("1".equals(type)){
//				sheetName = "菜单点击量统计表";
//			}else if("2".equals(type)){
//				sheetName = "用户点击量统计表";
//			}
//			//创建样式
//			HSSFCellStyle styleTitle = wb.createCellStyle();//居中对其
//			HSSFCellStyle styleCenter = wb.createCellStyle();//居中对其
//			HSSFCellStyle styleCenterBold = wb.createCellStyle();//居中粗体
//			HSSFCellStyle styleCenterRedBold = wb.createCellStyle();//居中红色粗体
//			HSSFCellStyle styleRight = wb.createCellStyle();//右对齐
//			HSSFCellStyle styleRightRedBold = wb.createCellStyle();//右对齐红色粗体
//			//设置对齐方式
//			styleTitle.setAlignment(HorizontalAlignment.CENTER);
//			styleCenter.setAlignment(HorizontalAlignment.CENTER);
//			styleCenterBold.setAlignment(HorizontalAlignment.CENTER);
//			styleCenterBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
////			styleCenterBold.setFillForegroundColor(HSSFColor.YELLOW.index);
////			styleCenterBold.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
////			styleCenterBold.setFillBackgroundColor(HSSFColor.YELLOW.index); 
//			styleCenterRedBold.setAlignment(HorizontalAlignment.CENTER);
//			styleRight.setAlignment(HorizontalAlignment.RIGHT);
//			styleRightRedBold.setAlignment(HorizontalAlignment.RIGHT);
//			//设置字体样式及颜色
//			Font fontBold = wb.createFont();  
//			Font fontRedBold = wb.createFont();  
//			Font fontTitle = wb.createFont();  
//			fontBold.setBold(true);
//			fontRedBold.setColor(HSSFColor.RED.index);  
//			fontRedBold.setBold(true);
//			fontTitle.setBold(true);
//			fontTitle.setFontHeight((short) 280);
//			//设置样式
//			styleTitle.setFont(fontTitle);
//			styleCenterBold.setFont(fontBold); 
//			styleCenterRedBold.setFont(fontRedBold); 
//			styleRightRedBold.setFont(fontRedBold);
//			//分享列数
//			int fxColNum = 0;
//			//如果存在数据则创建excel
//			if(null != listMenuTitle && null != listContent && listMenuTitle.size() > 0 && listContent.size() > 0){
//				
//				//查询所有的菜单名称，封装成数组
//				String[] excelHeader = new String[listMenuTitle.size() + 2];
//				String[] excelHeaderChange = new String[listMenuTitleChange.size() + 2];
//				excelHeader[0] = null;
//				excelHeaderChange[0] = null;
//				String s1 = "", s2 = "";
//				for(int i = 0; i< listMenuTitle.size(); i++){
//					s1 = listMenuTitle.get(i).get("MENU_NAME") + "";
//					s2 = listMenuTitleChange.get(i).get("MENU_NAME") + "";
//					if(!"01".equalsIgnoreCase(menuType)){
//						if("991001".equalsIgnoreCase(s1.substring(1, 7)) || "991002".equalsIgnoreCase(s1.substring(1, 7))){
//							fxColNum++;
//						}
//					}
//					excelHeader[i+1] = s1;
//					excelHeaderChange[i+1] = s2;
//				}
//				//根据type判断导出类型来创建合计列标题
//				if("1".equals(type)){
//					excelHeader[excelHeader.length - 1] = sum1;
//				}else if("2".equals(type)){
//					excelHeader[excelHeader.length - 1] = sum2;
//				}
//				//创建sheet
//				HSSFSheet sheet = wb.createSheet(sheetName);
//				//创建行
//				HSSFRow row = sheet.createRow((int) 0);
//				//创建表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//				if("2".equalsIgnoreCase(type) && "03".equalsIgnoreCase(menuType)){
//					sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, excelHeader.length - 1)); 
//				}else{
//					sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelHeader.length - 1)); 
//				}
//				//设置表头
//				HSSFCell cellTitle = row.createCell(0);
//				cellTitle.setCellValue(sheetName);
//				cellTitle.setCellStyle(styleTitle);
//				//创建行：循环创建Page标题
//				if(null!= listPageTitle && listPageTitle.size() > 0 && menuTitleRowNum == 2){
//					row = sheet.createRow((int) 1);
//					if("1".equalsIgnoreCase(type) && "03".equalsIgnoreCase(menuType)){
//						//业务办理类
//						int menuNum = 0, colStartNum = 1, colEndtNum = 0;
//						for (int i = 0; i < listPageTitle.size(); i++) {
//							colStartNum = colStartNum + menuNum;//起始列号
//							menuNum = Integer.valueOf(listPageTitle.get(i).get("MENU_NUM")+"").intValue();//菜单数
//							colEndtNum = colEndtNum + menuNum;//终止列号
//							//创建pageName表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//							if(colEndtNum > colStartNum){
//								sheet.addMergedRegion(new CellRangeAddress(1, 1, colStartNum, colEndtNum));
//							} 
//							//创建单元格
//							HSSFCell cell = row.createCell(colStartNum);
//							//创建数据
//							cell.setCellValue(listPageTitle.get(i).get("PAGE_NAME")+"");
//							//设置样式
//							cell.setCellStyle(styleCenterBold);
//						}
//						//创建pageName表头合并列，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//						sheet.addMergedRegion(new CellRangeAddress(1, 2, excelHeader.length - 1, excelHeader.length - 1));
//						//创建单元格
//						HSSFCell cell = row.createCell(colEndtNum + 1);
//						//创建数据;根据type判断导出类型来创建合计列标题
//						if("1".equals(type)){
//							cell.setCellValue(sum1);
//						}else if("2".equals(type)){
//							cell.setCellValue(sum2);
//						}
//						//设置样式
//						cell.setCellStyle(styleCenterBold);
//					}else if("04".equalsIgnoreCase(menuType)){
//						//其他类
//						HSSFRow row2 = sheet.createRow((int) 2);
//						for (int i = 0; i < excelHeader.length; i++) {
//							if(fxColNum == 2){
//								//分享
//								if(i == excelHeader.length - 3 || i == excelHeader.length - 2){
//									if(i == excelHeader.length - 3){
//										//创建pageName表头"分享"，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//										sheet.addMergedRegion(new CellRangeAddress(1, 1, i, (i+1)));
//										//创建单元格
//										HSSFCell cell = row.createCell(i);
//										//创建数据
//										cell.setCellValue("分享");
//										//设置样式
//										cell.setCellStyle(styleCenterBold);
//									}
//									//创建单元格
//									HSSFCell cell2 = row2.createCell(i);
//									//创建数据
//						            if(null != excelHeader[i] && excelHeader[i].length() > 7){
//						            	if("分享".equals(excelHeader[i].substring(7))){
//						            		cell2.setCellValue("菜单点击量");
//						            	}else{
//						            		cell2.setCellValue(excelHeader[i].substring(7));
//						            	}
//						            }else{
//						            	cell2.setCellValue(excelHeader[i]);
//						            }
//									//设置样式
//									cell2.setCellStyle(styleCenterBold);
//								}else{
//									//创建pageName表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//									sheet.addMergedRegion(new CellRangeAddress(1, 2, i, i));
//									//创建单元格
//									HSSFCell cell = row.createCell(i);
//									//创建数据
//						            if(null != excelHeader[i] && excelHeader[i].length() > 7){
//						            	cell.setCellValue(excelHeader[i].substring(7));
//						            }else{
//						            	cell.setCellValue(excelHeader[i]);
//						            }
//									//设置样式
//									cell.setCellStyle(styleCenterBold);
//								}
//							}else{
//								//创建pageName表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//								sheet.addMergedRegion(new CellRangeAddress(1, 2, i, i));
//								//创建单元格
//								HSSFCell cell = row.createCell(i);
//								//创建数据
//					            if(null != excelHeader[i] && excelHeader[i].length() > 7){
//					            	if("03".equalsIgnoreCase(menuType) && "分享".equals(excelHeader[i].substring(7))){
//					            		cell.setCellValue("菜单点击量");
//					            	}else{
//					            		cell.setCellValue(excelHeader[i].substring(7));
//					            	}
//					            }else{
//					            	cell.setCellValue(excelHeader[i]);
//					            }
//								//设置样式
//								cell.setCellStyle(styleCenterBold);
//							}
//				            //设置列宽
//							sheet.autoSizeColumn(i);
//							if(null != excelHeader[i] && excelHeader[i].length() > 0){
//								sheet.setColumnWidth(i, 3000);
//							}else{
//								sheet.setColumnWidth(i, 1800);
//							}
//						}
//					}
//				}
//				//创建行：循环创建列标题（其他类的标题由上面创建）
//				if(!"04".equalsIgnoreCase(menuType)){
//					row = sheet.createRow((int) menuTitleRowNum);
//					for (int i = 0; i < excelHeader.length; i++) {
//						//最后一列合计列，如果有page的话，则不做任何操作，因为在上面已经将合计写入该单元格了
//						if("1".equalsIgnoreCase(type) && null != listPageTitle && listPageTitle.size() > 0 && menuTitleRowNum == 2 && i == excelHeader.length - 1){
//							continue;
//						}
//						//创建单元格
//						HSSFCell cell = row.createCell(i);
//						//创建数据
//			            if(null != excelHeader[i] && excelHeader[i].length() > 7){
//			            	if("1".equalsIgnoreCase(type) && "03".equalsIgnoreCase(menuType)){
//			            		cell.setCellValue(excelHeaderChange[i].substring(7));
//			            	}else{
//			            		cell.setCellValue(excelHeader[i].substring(7));
//			            	}
//			            }else{
//			            	cell.setCellValue(excelHeader[i]);
//			            }
//			            //设置样式
//			            cell.setCellStyle(styleCenterBold);
//			            //设置列宽
//						sheet.autoSizeColumn(i);
//						if(null != excelHeader[i] && excelHeader[i].length() > 0){
//							sheet.setColumnWidth(i, 2700);
//						}else{
//							sheet.setColumnWidth(i, 1800);
//						}
//					}
//				}
//				//循环创建行：数据内容
//				for (int i = 0; i < listContent.size(); i++) {
//					HSSFCell cell = null;
//					row = sheet.createRow(i + titleRowCount);
//					Map<String, Object> map = listContent.get(i);
//					//通过标题获取对应值
//					for (int j = 0; j < excelHeader.length; j++) {
//						cell = row.createCell(j);
//						if(j == 0){
//							cell.setCellValue(map.get("AREA_NAME")+"");
//							cell.setCellStyle(styleCenterBold);
//						}else{
//							cell.setCellValue(map.get("'"+excelHeader[j]+"'")+"");
//							if(j == excelHeader.length - 1){
//								cell.setCellStyle(styleRightRedBold);
//							}else{
//								cell.setCellStyle(styleRight);
//							}
//						}
//					}
//				}
//				//创建行：合计信息
//				row = sheet.createRow(listContent.size() + titleRowCount);
//				HSSFCell cell0 = row.createCell(0);
//				cell0.setCellValue("合计");
//				cell0.setCellStyle(styleCenterRedBold);
//				for (int j = 0; j < listSum.size(); j++) {
//					HSSFCell cell = row.createCell(j+1);
//					Map<String, Object> map = listSum.get(j);
//					cell.setCellValue(map.get("ACOUNT_NUM") + "");
//					cell.setCellStyle(styleRightRedBold);
//				}
//			}
//		}
//		return wb;
//	}
//	
//	/**
//	 * 消息信息推送导出excel
//	 */
//	@Override
//	public HSSFWorkbook msgExport(MsgTotalData msgTotalData) {
//		String type = msgTotalData.getType();
//		String menu_type = msgTotalData.getMenu_type();
//		String busName = "";
//		int busItemCount = 1;
//		//获取所有的菜单名称
//		List<Map<String, Object>> listTitle = null;
//		List<Map<String, Object>> listContent = null;
//		//根据type判断导出类型并获取统计明细及合计
//		if("1".equals(type)){
//			listTitle = msgTotalServiceimpl.getMsgTotalTitleList(msgTotalData);
//		}else if("2".equals(type)){
//			listTitle = msgTotalServiceimpl.getMsgTotalTitleList(menu_type);
//			List<Map<String, Object>> l = msgTotalServiceimpl.getBusCountList(menu_type);
//			if(null != l && l.size() > 0){
//				Map<String, Object> map = (Map<String, Object>)l.get(0);
//				busName = map.get("MSG_BUS_NAME")+"";
//				busItemCount = Integer.valueOf(map.get("ITEM_COUNT")+"");
//			}
//		}
//		listContent = msgTotalServiceimpl.getMsgTotalList(msgTotalData);
//		//创建excel
//		HSSFWorkbook wb = new HSSFWorkbook();
//		//判空
//		if(null != listTitle && null != listContent && listTitle.size() > 0 && listContent.size() > 0){
//			//设置excel sheet名称
//			String sheetName = "";
//			String sum1 = "合计";
//			//根据type判断导出类型来创建合计列标题
//			if("1".equals(type)){
//				sheetName = "业务消息推送统计表";
//			}else if("2".equals(type)){
//				sheetName = "业务环节消息推送统计表";
//			}
//			//创建样式
//			HSSFCellStyle styleTitle = wb.createCellStyle();//居中对其
//			HSSFCellStyle styleCenter = wb.createCellStyle();//居中对其
//			HSSFCellStyle styleCenterBold = wb.createCellStyle();//居中粗体
//			HSSFCellStyle styleCenterRedBold = wb.createCellStyle();//居中红色粗体
//			HSSFCellStyle styleRight = wb.createCellStyle();//右对齐
//			HSSFCellStyle styleRightRedBold = wb.createCellStyle();//右对齐红色粗体
//			//设置对齐方式
//			styleTitle.setAlignment(HorizontalAlignment.CENTER);
//			styleCenter.setAlignment(HorizontalAlignment.CENTER);
//			styleCenterBold.setAlignment(HorizontalAlignment.CENTER);
//			styleCenterBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
////			styleCenterBold.setFillForegroundColor(HSSFColor.YELLOW.index);
////			styleCenterBold.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND); 
////			styleCenterBold.setFillBackgroundColor(HSSFColor.YELLOW.index); 
//			styleCenterRedBold.setAlignment(HorizontalAlignment.CENTER);
//			styleRight.setAlignment(HorizontalAlignment.RIGHT);
//			styleRightRedBold.setAlignment(HorizontalAlignment.RIGHT);
//			//设置字体样式及颜色
//			Font fontBold = wb.createFont();  
//			Font fontRedBold = wb.createFont();  
//			Font fontTitle = wb.createFont();  
//			fontBold.setBold(true);
//			fontRedBold.setColor(HSSFColor.RED.index);  
//			fontRedBold.setBold(true);
//			fontTitle.setBold(true);
//			fontTitle.setFontHeight((short) 280);
//			//设置样式
//			styleTitle.setFont(fontTitle);
//			styleCenterBold.setFont(fontBold); 
//			styleCenterRedBold.setFont(fontRedBold); 
//			styleRightRedBold.setFont(fontRedBold);
//			//如果存在数据则创建excel
//			if(null != listTitle && null != listContent && listTitle.size() > 0 && listContent.size() > 0){
//				//查询所有的菜单名称，封装成数组
//				String[] excelHeader = new String[listTitle.size() + 2];
//				excelHeader[0] = null;
//				String s1 = "";
//				for(int i = 0; i< listTitle.size(); i++){
//					if("1".equals(type)){
//						s1 = listTitle.get(i).get("MSG_BUS_NAME") + "";
//					}else if("2".equals(type)){
//						s1 = listTitle.get(i).get("MSG_BUS_ITEM_NAME") + "";
//					}
//					excelHeader[i+1] = s1;
//				}
//				excelHeader[excelHeader.length - 1] = sum1;
//				//创建sheet
//				HSSFSheet sheet = wb.createSheet(sheetName);
//				//创建行
//				HSSFRow row = sheet.createRow((int) 0);
//				//创建表头，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//				sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelHeader.length - 1));
//				//设置表头
//				HSSFCell cellTitle = row.createCell(0);
//				cellTitle.setCellValue(sheetName);
//				cellTitle.setCellStyle(styleTitle);
//				//开始创建列标题
//				if("1".equals(type)){
//					//创建列标题
//					row = sheet.createRow((int) 1);
//				}else if("2".equals(type)){
//					//创建业务标题
//					row = sheet.createRow((int) 1);
//					//创建业务标题，合并单元格(new CellRangeAddress参数：//参数 1:起始行号   参数 2:终止行号   参数 3:起始列号   参数 4:终止列号 )
//					sheet.addMergedRegion(new CellRangeAddress(1, 1, 1, busItemCount));
//					//创建单元格
//					HSSFCell cell = row.createCell(1);
//					//创建数据
//					cell.setCellValue(busName);
//		            //设置样式
//		            cell.setCellStyle(styleCenterBold);
//					//创建列标题
//					row = sheet.createRow((int) 2);
//				}
//				//循环写列标题
//				String v = "";
//				for (int i = 0; i < excelHeader.length; i++) {
//					//创建单元格
//					HSSFCell cell = row.createCell(i);
//					v = excelHeader[i];
//					if("2".equals(type) && null != excelHeader[i] && excelHeader[i].length() > 4){
//						v = v.substring(4, v.length());
//					}
//					//创建数据
//					cell.setCellValue(v);
//		            //设置样式
//		            cell.setCellStyle(styleCenterBold);
//		            //设置列宽
//					sheet.autoSizeColumn(i);
//					if(null != excelHeader[i] && excelHeader[i].length() > 0){
//						sheet.setColumnWidth(i, 3000);
//					}else{
//						sheet.setColumnWidth(i, 1800);
//					}
//				}
//				//循环创建行：数据内容
//				for (int i = 0; i < listContent.size(); i++) {
//					HSSFCell cell = null;
//					if("1".equals(type)){
//						row = sheet.createRow(i + 2);
//					}else if("2".equals(type)){
//						row = sheet.createRow(i + 3);
//					}
//					Map<String, Object> map = listContent.get(i);
//					//通过标题获取对应值
//					for (int j = 0; j < excelHeader.length; j++) {
//						cell = row.createCell(j);
//						if(j == 0){
//							cell.setCellValue(map.get("AREA_NAME")+"");
//							cell.setCellStyle(styleCenterBold);
//						}else if(j == excelHeader.length - 1){
//							cell.setCellValue(map.get("合计")+"");
//							cell.setCellStyle(styleRightRedBold);
//						}else{
//							v = map.get("'"+excelHeader[j]+"'")+"";
//							if(null == v || "null".equals(v) || StringUtils.isEmpty(v)){
//								cell.setCellValue("0");
//							}else{
//								cell.setCellValue(v);
//							}
//							//最后一行合计，全部显示红色粗体
//							if(i == listContent.size() - 1){
//								cell.setCellStyle(styleRightRedBold);
//							}else{
//								cell.setCellStyle(styleRight);
//							}
//						}
//					}
//				}
//			}
//		}
//		return wb;
//	}

}
