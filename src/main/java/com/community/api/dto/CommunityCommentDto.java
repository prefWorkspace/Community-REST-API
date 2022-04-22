package com.community.api.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("comment")
public class CommunityCommentDto {
	
	private int comcNo;
	private int comcParent;
	private String comcContents;
	private String comcDate;
	
	private int comNo;
	private int comType;
	
	private int memNo;
	private String memNickname;
	
	List<CommunityCommentDto> childCommentList;

}