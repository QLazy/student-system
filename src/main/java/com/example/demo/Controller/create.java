package com.example.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.myService;


@Controller
public class create {
	
	@Autowired
	private myService myservice;
	//输入表名来创建一张表
	@RequestMapping("createTable")
	public String createTable(HttpServletRequest request,Map<String,Object> map) {
		
		//获取需要创建的表单名
		String sclass = request.getParameter("sclass");
		//调用myService中的创造函数
		boolean createTabByExcel = myservice.createTabByExcel(sclass);
		//利用map传值，在前端显示结果
		map.put("createTable",createTabByExcel);
		return "result";
	}
}
