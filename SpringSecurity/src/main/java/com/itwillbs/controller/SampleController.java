package com.itwillbs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sample")
// @Log4j
public class SampleController {

	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	// 로그인 하지 않은 사용자도 접근 가능한 URI
	@GetMapping(value ="/all")
	public void doALL() {
		logger.info("doALL 실행"); 
	}
	
	// 로그인 한 사용자들만이 접근할수 있는 URI
	@RequestMapping( value = "/member" , method = RequestMethod.GET)
	public void doMember() {
		
		logger.info("doMember 실행"); 
	}
	
	// 로그인 한 사용자들 중에서 관리자 권한을 가진 사용자만이 접근할 수 있는 uri
	@GetMapping(value = "/admin")
	public void doAdmin() {
		logger.info("doAdmin 실행"); 
		
	}
	
	
}

