package com.community.api.domain;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtResponse {
	
	public static final String SUCCESS_MESSAGE = "성공";
    public static final String SERVER_ERROR_MESSAGE = "실패";
	
	private HttpStatus statusCode;
    private String message;
	private String jwt;
	
	public JwtResponse(){}
    
    public static JwtResponse successInstance() {
        return new JwtResponse().success();
    }
    
    public static JwtResponse failInstance() {
        return new JwtResponse().fail();
    }
	
	public JwtResponse success() {
        statusCode = HttpStatus.OK;
        message = SUCCESS_MESSAGE;
        return this;
    }

    public JwtResponse fail() {
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        message = SERVER_ERROR_MESSAGE;
        return this;
    }

}