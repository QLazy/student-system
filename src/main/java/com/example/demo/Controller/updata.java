package com.example.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.myService;
import com.example.demo.entity.Student;
@Controller
public class updata {
	@Autowired
	private myService myservice;
	
	//更新一个学生信息
	@RequestMapping("updataStudent")
	public String updataStudent(HttpServletRequest request,Map<String,Object> map) {
		//创建学生
		Student student = new Student();
		//获取前端学生数据并赋值
		student.setSid(Integer.parseInt( request.getParameter("sid")));
		student.setSname(request.getParameter("sname"));
		student.setSaddress(request.getParameter("saddress"));
		student.setSage(Integer.parseInt(request.getParameter("sage")));
		student.setSclass(request.getParameter("sclass"));
		String myClass = request.getParameter("sclass");
		boolean updata = myservice.updata(student);
		map.put("updataStudent",updata);
		return "redirect:queryAllByClass?sclass="+myClass;
	}
	
}
