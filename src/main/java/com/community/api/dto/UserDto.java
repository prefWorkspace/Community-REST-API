package com.community.api.dto;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("user")
public class UserDto {
	
	private int memNo;
	private String memId;
	private String memPw;
	private String memName;
	private String memNickname;
	private String memEmail;
	private String memPhone;
	private String memRole;
	private String memDatetime;

}