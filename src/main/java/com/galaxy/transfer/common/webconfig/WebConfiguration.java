package com.galaxy.transfer.common.webconfig;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.galaxy.transfer.common.webconfig.filter.LoginFilter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	@Autowired
	private Environment env;
//	/**
//	 * 设置servlet，如果设置多个请重复如下代码即可,filter及listener同样
//	 * @return
//	 */
//	@Bean
//	public ServletRegistrationBean getOneServlet(){
//		OneServlet demoServlet=new OneServlet();
//		ServletRegistrationBean registrationBean=new ServletRegistrationBean();
//		registrationBean.setServlet(demoServlet);
//		List<String> urlMappings=new ArrayList<String>();
//		urlMappings.add("/one");				////访问，可以添加多个
//		registrationBean.setUrlMappings(urlMappings);
//		registrationBean.setLoadOnStartup(1);
//		return registrationBean;
//	}
	
	/**
	 * 配置过滤器(Filter)
	 * @return
	 */
	@Bean
	public FilterRegistrationBean getDemoFilter(){
		LoginFilter demoFilter=new LoginFilter();
		FilterRegistrationBean registrationBean=new FilterRegistrationBean();
		registrationBean.setFilter(demoFilter);
		List<String> urlPatterns=new ArrayList<String>();
		urlPatterns.add("/*");//拦截路径，可以添加多个
		registrationBean.setUrlPatterns(urlPatterns);
		registrationBean.setOrder(1);
		registrationBean.addInitParameter("excludes", env.getProperty("web.loginFilter.excludes"));
		return registrationBean;
	}
	
//	/**
//	 * 配置listener
//	 * @return
//	 */
//	@Bean
//	public ServletListenerRegistrationBean<EventListener> getDemoListener(){
//		ServletListenerRegistrationBean<EventListener> registrationBean
//		                           =new ServletListenerRegistrationBean<>();
//		registrationBean.setListener(new DemoListener());
////		registrationBean.setOrder(1);
//		return registrationBean;
//	}
}
