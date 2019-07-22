package com.example.demo.Controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Service.myService;
@Controller
public class delete {
	@Autowired
	private myService myservice;
	
	//删除一个学生
	@RequestMapping("delStuByID")
	public String delStuByID(HttpServletRequest request,Map<String,Object> map) {
		//获取前端需要删除的ID
		int id = Integer.parseInt( request.getParameter("sid"));
		String parameter = request.getParameter("sname");
		String myClass = request.getParameter("sclass");
		//调用service函数
		boolean delete = myservice.delete(myClass,id);
		System.out.println(parameter);
		//将结果放到单独页面显示
		map.put("delStuByID",delete);
		return "redirect:queryAllByClass?sclass="+myClass;
	}
	
}
