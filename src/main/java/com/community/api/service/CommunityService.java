package com.community.api.service;

import java.util.List;

import com.community.api.dto.CommunityCommentDto;
import com.community.api.dto.CommunityDto;

public interface CommunityService {

	List<CommunityDto> getCommunityList(CommunityDto communityDto);

	List<CommunityDto> getMyCommunityList(CommunityDto communityDto);

	CommunityDto getCommunityDetails(int comNo);

	int insertCommunityContent(CommunityDto communityDto);

	int modifyCommunityContent(CommunityDto communityDto);

	int deleteCommunityContent(int comNo, int memNo);

	List<CommunityCommentDto> getCommunityComment(CommunityCommentDto communityCommentDto);

	List<CommunityCommentDto> getMyCommunityComment(CommunityCommentDto communityCommentDto);

	CommunityCommentDto getCommunityCommentTypePiece(int comcNo);

	int insertCommunityComment(CommunityCommentDto communityCommentDto);

	int modifyCommunityComment(CommunityCommentDto communityCommentDto);

	int deleteCommunityComment(int comcNo);
	
}