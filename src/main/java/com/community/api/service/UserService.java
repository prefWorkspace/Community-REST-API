package com.community.api.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.community.api.entity.User;

public interface UserService {

	User findTargetUserInfo(String memId);

	UserDetails loadUserByUsername(String memId);

}