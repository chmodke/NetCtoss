package org.kehao.netctoss.test.controller.admininfo;

import junit.framework.Assert;

import org.apache.commons.codec.binary.Base64;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kehao.netctoss.model.NetCtossResult;
import org.kehao.netctoss.web.controller.admininfo.AdminInfoLoginController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AdminInfoLoginControllerTest {
	@Autowired//注入要测试的Controller
	private AdminInfoLoginController controller;
	//发送测试请求
	private MockMvc mockMvc;
	@Before
	public void init(){
		mockMvc=MockMvcBuilders.standaloneSetup(controller).build();
	}
	@After
	public void destroy(){
		
	}
	
	@Test
	public void adminInfoControllerLogin() throws Exception{
		String msg="admin"+":"+"123";
		String base64_msg=Base64.encodeBase64String(msg.getBytes());
		String header="Base "+base64_msg;
		//发送执行一个HTTP请求
		RequestBuilder request=MockMvcRequestBuilders
		.post("/login/checkLogin.do")
		.header("header", header);//传数据
		
		MvcResult result=mockMvc.perform(request)
		.andDo(MockMvcResultHandlers.print())//将请求头和响应头打印
		.andExpect(MockMvcResultMatchers.status().isOk())//期望返回状态码200
		.andReturn();//用来返回结果
		
		//提取响应中的json字符串
		String jsonStr=result.getResponse().getContentAsString();
		System.out.println("----------------------------"+'\n'+jsonStr+'\n'+"----------------------------");
		//将json字符串转成java对象
		ObjectMapper mapper=new ObjectMapper();
		NetCtossResult netResult=mapper.readValue(jsonStr, NetCtossResult.class);
		//断言
		Assert.assertEquals(0, netResult.getStatus().intValue());
	}
}
