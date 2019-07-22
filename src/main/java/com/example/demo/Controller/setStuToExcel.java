package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.writeExcel;

public class setStuToExcel {
	@RequestMapping("/found")
	public void found(String excelPath) {
		writeExcel we = new writeExcel();
		
		Map<String, String> dataMap=new HashMap<String, String>();
		dataMap.put("BankName", "BankName");
		dataMap.put("Addr", "Addr");
		dataMap.put("Phone", "Phone");
		List<Map> list=new ArrayList<Map>();
		list.add(dataMap);
		we.writeInExcel(list, 3, excelPath);
	}
}
