package com.example.demo.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class myDao {
	private static final String EXCEL_XLS = "xls";	
    private static final String EXCEL_XLSX = "xlsx";
    //判断输出到的Excel文件的版本
	public static Workbook getWorkbook(File file) throws IOException{
		Workbook wb = null;
		FileInputStream in = new FileInputStream(file);
		if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
			wb = new HSSFWorkbook(in);
		}else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
			wb = new XSSFWorkbook(in);
		}
		return wb;
	}
}
