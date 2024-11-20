package com.itwillbs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 
 *  로그인 성공시 처리하는 동작
 *  (로그인된 계정 정보에 따른 페이지 이동)
 */
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {
	private static final Logger logger = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		logger.info(" 인증 성공! => 로그인 성공! ");
		
		// 로그인한 사용자의 권한 체크
		
		List<String> roleNames = new ArrayList<String>();
		
		/*
		 * authentication.getAuthorities().forEach(authority ->
		 * roleNames.add(authority.getAuthority()));
		 */		
		authentication.getAuthorities().forEach(new Consumer<GrantedAuthority>() {
			@Override
			public void accept(GrantedAuthority authority) {
				roleNames.add(authority.getAuthority());
			}
		});	
		
		logger.info("roleNames : {}",roleNames);
		
		// 권한에 따른 페이지 이동
		
		if(roleNames.contains("ROLE_ADMIN")) {//ROLE_ADMIN 권한이 있을때 
			logger.info("관리자 로그인 성공! ");
			
			response.sendRedirect("/sample/admin");
			return;
		}
		
		if(roleNames.contains("ROLE_MEMBER")) {
			logger.info("일반 회원 로그인 성공!");
			
			response.sendRedirect("/sample/member");
			return;
		}else {
			logger.info("비회원 접근!");
			response.sendRedirect("/sample/all");
			
		}
		
	}
}
