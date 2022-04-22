package com.community.api.dto;

import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Alias("community")
public class CommunityDto {
	
	private int comNo;
	private int comType;
	private String comTitle;
	private String comContents;
	private String comDate;
	
	private int memNo;
	private String memId;
	private String memName;
	private String memNickname;
	private String memEmail;
	private String memPhone;
	
	private int limit;
	private int offset;
	private int filter;
	
	List<CommunityCommentDto> commentList;

}