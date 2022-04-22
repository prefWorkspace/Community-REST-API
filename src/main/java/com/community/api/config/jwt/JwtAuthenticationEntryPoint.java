package com.community.api.config.jwt;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
	
	private static final long serialVersionUID = -7858869558953243875L;

	@Override
	public void commence(HttpServletRequest request, 
						 HttpServletResponse response,
						 AuthenticationException authException) throws IOException, ServletException {
		
//		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
		
		String errMsg = "토큰이 비어있습니다.";
		if (authException.getMessage().contains("mem_id")) {
			errMsg = "잘못된 유저 아이디 입니다.";
		} else if (authException instanceof BadCredentialsException) {
			errMsg = "잘못된 유저 비밀번호 입니다.";
		}
		
		response.setStatus(401);
		response.getWriter().print(errMsg);
		response.getWriter().flush();
	}
	
}
