package com.galaxy.transfer.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CUtils {
	private final Logger log = LoggerFactory.getLogger(CUtils.class);
	private static CUtils utils = null;
	
	public static synchronized CUtils get(){
		if(utils==null){
			utils = new CUtils();
		}
		return utils;
	}
	
	public String getUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * Map 转 Json型字符串
	 * @param map
	 * @return 
	 */
	public String map2String(Map<String,? extends Object> map){
		return mapIsNotEmpty(map)?object2JSONString(map):null;
	}
	
	/**
	 * object 转 Integer
	 * @param obj
	 * @param defValue
	 * @return
	 */
	public Integer object2Integer(Object obj,Integer... defValue){
		int resInteger = arrayIsNotEmpty(defValue)?defValue[0]:0;
		try{
			resInteger = Integer.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resInteger;
	}
	
	/**
	 * object 转 double
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Double object2Double(Object obj,Double... defVal){
		Double resVal = arrayIsNotEmpty(defVal)?defVal[0]:0;
		try{
			resVal = Double.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * object 转 boolean
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Boolean object2Boolean(Object obj,Boolean... defVal){
		Boolean resVal = arrayIsNotEmpty(defVal)?defVal[0]:false;
		try{
			resVal = Boolean.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * object 转 date
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Date object2Date(Object obj,Date... defVal){
		Date resVal = arrayIsNotEmpty(defVal)?defVal[0]:new Date();
		try{
			resVal = (Date)obj;
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * object 转 Short
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Short object2Short(Object obj,Short... defVal){
		Short resVal = arrayIsNotEmpty(defVal)?defVal[0]:0;
		try{
			resVal = Short.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * object 转 long
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Long object2Long(Object obj,Long... defVal){
		Long resVal = arrayIsNotEmpty(defVal)?defVal[0]:0L;
		try{
			resVal = Long.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * object 转 Float
	 * @param obj
	 * @param defVal
	 * @return
	 */
	public Float object2Float(Object obj,Float... defVal){
		Float resVal = arrayIsNotEmpty(defVal)?defVal[0]:0;
		try{
			resVal = Float.valueOf(object2String(obj));
		}catch(Exception e){
			e.printStackTrace();
		}
		return resVal;
	}
	
	/**
	 * 连接字符串
	 * @param str
	 * @return
	 */
	public String connectString(Object... str){
		String resString = null;
		if(arrayIsNotEmpty(str)){
			StringBuffer sb = new StringBuffer();
			for(Object obj : str){
				sb.append(obj);
			}
			resString = sb.toString();
		}
		return resString;
	}
	
	/**
	 * javaBean(Bean) 转 Map
	 * @param t
	 * @return
	 */
	public <T> Map<String,? extends Object> bean2Map(T t){
		Map<String,? extends Object> map = null;
		try{
			map = BeanUtils.describe(t);
			if(mapIsNotEmpty(map) && map.containsKey("class")){
				map.remove("class");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 判断 map 为空 
	 * @param map
	 * @return
	 */
	public boolean mapIsEmpty(Map<?,?> map){
		return (map==null || map.isEmpty())?true:false;
	}
	
	/**
	 * 判断 map 为非空
	 * @param map
	 * @return
	 */
	public boolean mapIsNotEmpty(Map<?,?> map){
		return !mapIsEmpty(map);
	}
	
	/**
	 * 判断 list 为空
	 */
	public boolean listIsEmpty(List<?> list){
		return !listIsNotEmpty(list);
	}
	
	/**
	 * 判断 list 为非空
	 */
	public boolean listIsNotEmpty(List<?> list){
		return  (list!=null && !list.isEmpty())?true:false;
	}
	
	/**
	 * 判断 字符串 为空
	 * @param str
	 * @return
	 */
	public boolean stringIsEmpty(Object str){
		String s = object2String(str);
		return (s==null || "".equals(s.trim()))?true:false;
	}
	
	/**
	 * 判断 字符串 非空
	 * @param str
	 * @return
	 */
	public boolean stringIsNotEmpty(Object str){
		return !stringIsEmpty(str);
	}
	
	/**
	 * Object 转 String
	 * @param object
	 * @param defValues
	 * @return
	 */
	public String object2String(Object object,String... defValues){
		String str = arrayIsNotEmpty(defValues)?defValues[0]:null;
		try{
			str = object!=null ? str = object.toString():null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return str;
	}
	
	/**
	 * 判断 数组 为空
	 */
	public <T> boolean arrayIsEmpty(T[] array){
		return (array==null || array.length<=0)?true:false;
	}
	
	/**
	 * 判断 数组 非空
	 */
	public <T> boolean arrayIsNotEmpty(T[] array){
		return !arrayIsEmpty(array);
	}
	
	/**
	 * 取得文件的扩展名
	 * @return
	 */
	public String getFileExtName(String fileName){
		return stringIsNotEmpty(fileName)?fileName.substring(fileName.indexOf(".")+1, 
				fileName.length()):"";
	}
	
	/**
	 * android端使用application/json的方式传输参数，此处进行特殊处理进行接收
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public String getRequestBody(HttpServletRequest request){
		String paramStrng = "";
		try{
			BufferedReader reader = request.getReader();
			String input = null;
			StringBuffer requestBody = new StringBuffer();
			while((input = reader.readLine()) != null) {
				requestBody.append(input);
			}
			reader.close();
			reader = null;
			paramStrng = requestBody.toString();
		}catch(Exception e){
			paramStrng = "";
		}
		return paramStrng;
	}
	
	public String List2JSONString(List<Map<String,Object>> list){
		return object2JSONString(list);
	}
	
	/**
	 * 将json转换为map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String,Object> jsonString2map(Object obj){
		Map<String,Object> map = null;
		if(obj!=null){
			ObjectMapper mapper = new ObjectMapper();
			try{
				map = mapper.readValue(object2String(obj), Map.class);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * 将字符串转为list
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> json2list(Object obj){
		List<T> list = null;
		if(obj!=null){
			ObjectMapper mapper = new ObjectMapper();
			try{
				list = mapper.readValue(this.object2String(obj), List.class);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void outputJson(ServletResponse response,Object object){
		try{
			response.setContentType("text/html;charset=GBK");
			response.reset();
			PrintWriter out = response.getWriter();
			out.print(object2JSONString(object));
			out.flush();
			out.close();
			out = null;
		}catch(Exception e){
			log.error(CUtils.class.getName() + "_outputJson",e);
		}
	}

	
	/**
	 * ------------- 私有方法 --------------------
	 */
	private String object2JSONString(Object object){
		String jsonString = null;
		try{
			jsonString = stringIsNotEmpty(object)?
					new ObjectMapper().writeValueAsString(object):null;
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonString;
	}
	
}
