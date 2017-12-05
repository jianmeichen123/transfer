package com.galaxy.transfer.business.test;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.galaxy.transfer.bean.TestBean;
import com.galaxy.transfer.business.test.service.ITestService;
import com.galaxy.transfer.common.CUtils;

@Controller
@RequestMapping("/test")
public class TestController {
	@Autowired
	private ITestService service;
	
	@RequestMapping("hello")
	@ResponseBody
	public Object hello(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> tt = new HashMap<String,Object>();
		
		
		
		TestBean bean = new TestBean();
		bean.setId(CUtils.get().getUUID());
		try{
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
	
			bean.setName("乔乔");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		
		service.saveTest(bean);
		
		tt.put("tdjgamtam", service.getTestList());
		
		return tt;
	}

}
