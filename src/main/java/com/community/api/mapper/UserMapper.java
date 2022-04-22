package com.community.api.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.community.api.entity.User;

@Mapper
public interface UserMapper {

	User findTargetUserInfo(String memId);
	
}