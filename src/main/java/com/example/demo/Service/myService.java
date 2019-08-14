package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.IStudent;
import com.example.demo.entity.Student;
@Service
public class myService {
	@Autowired
	private IStudent istudent;
	
	//分页查询全部学生
	public List<Student> queryAll(String table,int currentAllData,int pageStartData) {
		return istudent.findAll(table,currentAllData,pageStartData);
	}
	
	//根据ID查询班级中单个学生
	public Student queryOne(String table,int id) {
		return istudent.findStuByID(table,id);
	}
	
	//查询班级内全部学生数量
	public int queryStuNumByClass(String table) {
		return istudent.countStuNumByClass(table);
	}
	
	//查询全部表单
	public List<String> queryAllClass() {
		return istudent.findAllTable();
	}
	
	//创建一个新表单
	public boolean createTabByExcel(String table) {
		//根据表名创建一张新表
		istudent.createTable(table);
		//判断是否创建成功
		return tableExist(table);
	}
	
	//判断一张表是否存在
	public boolean tableExist(String table) {
		//判断表单是否存在
		List<String> queryAllClass = queryAllClass();
		for(int i=0;i<queryAllClass.size();i++) {
			queryAllClass.set(i,queryAllClass.get(i).toLowerCase());
		}
		return queryAllClass.contains(table);
	}
	//更新学生
	public boolean updata(Student student) {
		if(queryOne(student.getSclass(),student.getSid())!=null) {
			istudent.updateByID(student);
			return true;
		}
		return false;
	}
	//删除学生
	public boolean delete(String table,int id) {
		if(queryOne(table,id)!=null) {
			istudent.deleteByID(table,id);
			return true;
		}
		return false;
	}
	//增加学生
	public boolean insert(Student student) {
		if(queryOne(student.getSclass(),student.getSid())==null) {
			istudent.insert(student);
			return true;
		}
		return false;
	}
}
