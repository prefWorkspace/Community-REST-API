package com.community.api.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.api.dto.CommunityCommentDto;
import com.community.api.dto.CommunityDto;
import com.community.api.mapper.CommunityMapper;
import com.community.api.service.CommunityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommunityServiceImpl implements CommunityService {
	
	private final CommunityMapper communityMapper;

	@Override
	public List<CommunityDto> getCommunityList(CommunityDto communityDto) {
		return communityMapper.getCommunityList(communityDto);
	}

	@Override
	public List<CommunityDto> getMyCommunityList(CommunityDto communityDto) {
		return communityMapper.getMyCommunityList(communityDto);
	}

	@Override
	public CommunityDto getCommunityDetails(int comNo) {
		return communityMapper.getCommunityDetails(comNo);
	}

	@Override
	public int insertCommunityContent(CommunityDto communityDto) {
		return communityMapper.insertCommunityContent(communityDto);
	}

	@Override
	public int modifyCommunityContent(CommunityDto communityDto) {
		return communityMapper.modifyCommunityContent(communityDto);
	}

	@Override
	public int deleteCommunityContent(int comNo, int memNo) {
		return communityMapper.deleteCommunityContent(comNo, memNo);
	}

	@Override
	public List<CommunityCommentDto> getCommunityComment(CommunityCommentDto communityCommentDto) {
		return communityMapper.getCommunityComment(communityCommentDto);
	}

	@Override
	public List<CommunityCommentDto> getMyCommunityComment(CommunityCommentDto communityCommentDto) {
		return communityMapper.getMyCommunityComment(communityCommentDto);
	}

	@Override
	public CommunityCommentDto getCommunityCommentTypePiece(int comcNo) {
		return communityMapper.getCommunityCommentTypePiece(comcNo);
	}

	@Override
	public int insertCommunityComment(CommunityCommentDto communityCommentDto) {
		return communityMapper.insertCommunityComment(communityCommentDto);
	}

	@Override
	public int modifyCommunityComment(CommunityCommentDto communityCommentDto) {
		return communityMapper.modifyCommunityComment(communityCommentDto);
	}

	@Override
	public int deleteCommunityComment(int comcNo) {
		return communityMapper.deleteCommunityComment(comcNo);
	}
	
	

}