package com.community.api.domain;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
	
	public static final String SUCCESS_MESSAGE = "성공";
    public static final String SERVER_ERROR_MESSAGE = "실패";
    
    private HttpStatus statusCode;
    private String message;
    private Object data;
    
    public Response(){}
    
    public static Response successInstance() {
        return new Response().success();
    }
    
    public static Response failInstance() {
        return new Response().fail();
    }
    
    public Response success() {
        statusCode = HttpStatus.OK;
        message = SUCCESS_MESSAGE;
        return this;
    }

    public Response fail() {
        statusCode = HttpStatus.INTERNAL_SERVER_ERROR;
        message = SERVER_ERROR_MESSAGE;
        return this;
    }
    
}