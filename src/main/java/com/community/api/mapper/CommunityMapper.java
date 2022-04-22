package com.community.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.community.api.dto.CommunityCommentDto;
import com.community.api.dto.CommunityDto;

@Mapper
public interface CommunityMapper {

	List<CommunityDto> getCommunityList(CommunityDto communityDto);

	List<CommunityDto> getMyCommunityList(CommunityDto communityDto);

	CommunityDto getCommunityDetails(int comNo);

	int insertCommunityContent(CommunityDto communityDto);

	int modifyCommunityContent(CommunityDto communityDto);

	int deleteCommunityContent(@Param("comNo") int comNo, @Param("memNo") int memNo);

	List<CommunityCommentDto> getCommunityComment(CommunityCommentDto communityCommentDto);

	List<CommunityCommentDto> getMyCommunityComment(CommunityCommentDto communityCommentDto);

	CommunityCommentDto getCommunityCommentTypePiece(int comcNo);

	int insertCommunityComment(CommunityCommentDto communityCommentDto);

	int modifyCommunityComment(CommunityCommentDto communityCommentDto);

	int deleteCommunityComment(int comcNo);
	
}