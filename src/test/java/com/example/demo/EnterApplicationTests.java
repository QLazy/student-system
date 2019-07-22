package com.example.demo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Controller.getStuByExcel;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnterApplicationTests {
	@Autowired
	private getStuByExcel gs;
	@Test
	public void contextLoads() throws IOException {
		Map<String,Object> map = new HashMap<>();
	}

}
