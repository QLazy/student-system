package com.example.demo.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Service.myService;
import com.example.demo.Service.readExcel;
import com.example.demo.entity.Student;

@RestController
public class getStuByExcel {
	@Autowired
	private myService myservice;
	
	@RequestMapping(value = "/testDownload", method = RequestMethod.GET)
	public void testDownload(HttpServletResponse response) {
	    String fileName = "read.xls";
		response.setHeader("content-type", "application/octet-stream");
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
		byte[] buff = new byte[1024];
		InputStream bis = null;
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			bis = new FileInputStream(new File("D:\\"+fileName));
			int read = bis.read(buff);
			while(read!=-1) {
				os.write(buff,0,buff.length);
				os.flush();
				read = bis.read(buff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("success");
	}
	@RequestMapping("/getStudent")
	public String getStudent(@RequestParam("exampleInputFile")MultipartFile afile,Map<String,Object> map) throws IllegalStateException, IOException {
		readExcel obj = new readExcel();
        // 此处为我创建Excel路径，临时放置上传文件的地址
		File newFile = new File("D:\\upload\\"+afile.getOriginalFilename());
		
		String name = newFile.getName().substring(0,newFile.getName().lastIndexOf(".")).toLowerCase();
		String suffix = newFile.getName().substring(newFile.getName().lastIndexOf(".")+1,newFile.getName().length());
		
		if(!suffix.equals("xls")) {
			return "请放入以 .xls 结尾的Excel文件";
		}
		afile.transferTo(newFile);
        List<List> excelList = obj.readExcel(newFile);
        List<Integer> count = new ArrayList<>();
        
        //获取文件名，不要拓展名，字母全部变小写
        System.out.println(suffix);
        //查询全部表单，判断是否重复
        System.out.println(myservice.tableExist(name));
        if(!myservice.tableExist(name)) {	//不重复就直接创建一张表
        	myservice.createTabByExcel(name);
        }
        
        
        //将数据写入数据库
        for (int i = 1; i < excelList.size(); i++) {
            List list = (List) excelList.get(i);
            Student student = new Student();
            
            //先将list中的数据转化为String后再转化成int
            student.setSid(Integer.parseInt((String)list.get(0)));
            student.setSage(Integer.parseInt((String)list.get(2)));
            //String直接强转即可
            student.setSname((String)list.get(1));
            student.setSaddress((String)list.get(3));
            student.setSclass(name);
            //根据文件名，将数据导入到相应的数据库中，判断是否重复，若重复，直接更新
            if(!myservice.insert(student)) {
            	//加个如果前端同意重复直接更新，那就加入更新函数
//            	myservice.updata(student);
            	System.out.println("此ID已存在："+student.getSid());
            	count.add(student.getSid());
            }
        }
//        map.put("result",count);
        return "上传成功";
	}
}
