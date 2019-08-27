package com.example.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Student;

@Controller
public class add {
//	@Autowired
//	private myService myservice;
	
	//增加一个学生
	@RequestMapping("/addStudentByClass")
	public String addStudent(HttpServletRequest request,Map<String,Object> map) {
		//创建学生
		Student student = new Student();
		//获取前端学生数据并赋值
		student.setSid(Integer.parseInt(request.getParameter("sid")));
		student.setSname(request.getParameter("sname"));
		student.setSaddress(request.getParameter("saddress"));
		student.setSage(Integer.parseInt(request.getParameter("sage")));
		student.setSclass(request.getParameter("sclass")); 
		String myClass = request.getParameter("sclass");
		//调用service函数
//		boolean insert = myservice.insert(student);
		map.put("addStudentByClass",myClass);
		return "redirect:queryAllByClass?sclass="+myClass;
	}
	
}
