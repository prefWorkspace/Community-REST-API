package com.community.api.error;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.community.api.dto.CommunityDto;

@Component
public class CommunityValidator {

	public void validate(CommunityDto communityDto, Errors errors) {
		System.out.println(errors.hasErrors());
	}
	
}