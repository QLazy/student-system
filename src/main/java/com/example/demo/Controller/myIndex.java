package com.example.demo.Controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class myIndex {
	@RequestMapping("/")
	public String mtInit(Map<String,Object> map) {
		//初始化一些参数
//		map.put("queryAll",null);
		
		return "index.html";
	}
}
