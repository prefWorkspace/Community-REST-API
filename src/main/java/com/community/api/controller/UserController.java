package com.community.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.community.api.config.jwt.JwtTokenUtil;
import com.community.api.domain.JwtResponse;
import com.community.api.entity.User;
import com.community.api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	private final PasswordEncoder passwordEncoder;
	
	private final JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/authentication")
	public ResponseEntity<JwtResponse> createJwt(@RequestParam("memId") String memId,
												 @RequestParam("memPw") String memPw,
												 HttpServletRequest request,
												 HttpServletResponse response) throws Exception {
		
		User user = userService.findTargetUserInfo(memId);
		
		if (user == null) {
			JwtResponse jwtResponse = JwtResponse.failInstance();
			return ResponseEntity.ok(jwtResponse);
		}
		
		authenticate(memPw, user.getMemPw());
		final String jwt = jwtTokenUtil.generateToken(user);
		JwtResponse jwtResponse = JwtResponse.successInstance();
		jwtResponse.setJwt(jwt);
		return ResponseEntity.ok(jwtResponse);
	}
	
	private void authenticate(String userPassword, String dbPassword) {
		boolean result = passwordEncoder.matches(userPassword, dbPassword);
		
		if (!result) {
			throw new BadCredentialsException("잘못된 유저 비밀번호 입니다.");
		} 
	}

}