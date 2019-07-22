package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.myService;
import com.example.demo.entity.Student;
@Controller
public class query {
	@Autowired
	private myService myservice;
	
	//查询一个学生的全部信息
	@RequestMapping("queryOneStudent")
	public String queryOneStudent(HttpServletRequest request,Map<String,Object> map) {
		//获取前端学生id
		int id = Integer.parseInt( request.getParameter("sid"));
		String sclass = request.getParameter("sclass");
		//根据ID查询学生
		Student queryOneById = myservice.queryOne(sclass,id);
		map.put("result",queryOneById);
		return "result";
	}
	
	//查询全部班级
	@RequestMapping("queryAllClass")
	public String queryAllClass(HttpServletRequest request,Map<String,Object> map) {
		//根据ID查询学生
		List<String> queryAllClass = myservice.queryAllClass();
		map.put("queryAllClass",queryAllClass);
		return "index";
	}
	//查询班级中全部学生
	@RequestMapping("queryAllByClass")
	public String queryAllByClass(HttpServletRequest request,Map<String,Object> map) {
		//获取前端数据
		String myClass = request.getParameter("sclass");
		//根据班级查询学生
		List<Student> queryAll = myservice.queryAll(myClass);
		List<String> queryAllClass = myservice.queryAllClass();
		map.put("queryAll",queryAll);
		map.put("queryAllClass",queryAllClass);
		map.put("myClass",myClass);
		return "index";
	}
}
