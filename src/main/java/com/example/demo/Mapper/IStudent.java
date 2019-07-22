package com.example.demo.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.Student;
@Mapper
public interface IStudent {
	@Update("update ${student.sclass} set " + 
			"sname=#{student.sname},saddress=#{student.saddress},sage=#{student.sage} " + 
			"where sid=#{student.sid}")
	public void updateByID(@Param("student")Student student);
	
	@Update("create table ${table}(  " + 
			"		sid number(10)," + 
			"		sname varchar2(20)," + 
			"		sage number(10)," + 
			"		saddress varchar2(100)," + 
			"		sclass varchar2(100)," + 
			"		passward number(10) default('123456')" + 
			"		)")
	public void createTable(@Param("table")String table);
	
	@Delete("delete from ${table} where sid=#{id}")
	public void deleteByID(@Param("table")String table,@Param("id")int id);
	
	@Insert("insert into ${student.sclass}(sid,sname,sage,saddress) "
			+ "values(#{student.sid},#{student.sname},#{student.sage},#{student.saddress})")
	public void insert(@Param("student")Student student);
	
	@Select("select * from ${table} where sid = #{id}")
	public Student findStuByID(@Param("table")String table,@Param("id")int id);
	
	@Select("select * from ${table}")
	public List<Student> findAll(@Param("table")String table);
	
	@Select("select * from tab ")
	public List<String> findAllTable();
	
	
}
