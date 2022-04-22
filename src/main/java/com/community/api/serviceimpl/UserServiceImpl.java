package com.community.api.serviceimpl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.community.api.entity.User;
import com.community.api.mapper.UserMapper;
import com.community.api.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {
	
	private final UserMapper userMapper;

	@Override
	public User findTargetUserInfo(String memId) {
		return userMapper.findTargetUserInfo(memId);
	}

	@Override
	public UserDetails loadUserByUsername(String memId) {
		User user = userMapper.findTargetUserInfo(memId);
		
		if (user == null) {
			throw new UsernameNotFoundException("해당 유저가 존재하지 않습니다 : " + memId);
		}
		
		return user;
	}
	
}