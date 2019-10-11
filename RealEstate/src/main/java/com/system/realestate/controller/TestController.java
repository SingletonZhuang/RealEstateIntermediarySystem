package com.system.realestate.controller;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;

public class TestController {
	
	private RestTemplate template = new RestTemplate();
	
	@SuppressWarnings("unchecked")
    @Test
	public void test() {
		
		JSONObject json = new JSONObject();
		json.put("userName","zhuang");
		json.put("passWord","123456");
		
		String url = "http://localhost:" + 7002 + "/unifiedmis/auth/login";
		HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        HttpEntity<String> formEntity = new HttpEntity<String>(json.toString(), headers);
        String result = template.postForObject(url, formEntity, String.class);
		//Junit的静态方法  assertTrue：判断两个值是否相等 ，如果为true，则运行success，反之Failure ； 没有错误提示
       
        System.err.println(result);

		
	}
	

	public static void main(String[] args) {
		
		RandomNumberGenerator saltGen = new SecureRandomNumberGenerator();
	    String salt = saltGen.nextBytes().toBase64();
	    String hashedPwd = new Sha256Hash("123456", salt, 1024).toBase64();
		
		System.out.println(salt);
		System.out.println(hashedPwd);
	}

}
