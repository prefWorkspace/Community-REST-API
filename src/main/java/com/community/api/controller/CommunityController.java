package com.community.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.community.api.anotation.ApiDescription;
import com.community.api.domain.Response;
import com.community.api.dto.CommunityCommentDto;
import com.community.api.dto.CommunityDto;
import com.community.api.entity.User;
import com.community.api.service.CommunityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {
	
	private final CommunityService communityService;
	
	@GetMapping("/list")
	@ApiDescription("커뮤니티 목록 조회")
	public ResponseEntity<Response> getCommunityList(CommunityDto communityDto) {
		List<CommunityDto> communityList = communityService.getCommunityList(communityDto);
		Response response = Response.successInstance();
		response.setData(communityList);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/my-list")
	@ApiDescription("내 커뮤니티 목록 조회")
	public ResponseEntity<Response> getMyCommunityList(CommunityDto communityDto, @AuthenticationPrincipal User user) {
		communityDto.setMemNo(user.getMemNo());
		List<CommunityDto> myCommunityList = communityService.getMyCommunityList(communityDto);
		Response response = Response.successInstance();
		response.setData(myCommunityList);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/detail/{comNo}")
	@ApiDescription("커뮤니티 상세 보기")
	public ResponseEntity<Response> getCommunityDetails(@PathVariable("comNo") int comNo) {
		CommunityDto communityInfo = communityService.getCommunityDetails(comNo);
		Response response = Response.successInstance();
		response.setData(communityInfo);
		return ResponseEntity.ok(response);
	}
		
	@PostMapping
	@ApiDescription("커뮤니티 글 등록")
	public ResponseEntity<Response> insertCommunityContent(CommunityDto communityDto, @AuthenticationPrincipal User user) {
		communityDto.setMemNo(user.getMemNo());
		int registrationResult = communityService.insertCommunityContent(communityDto);
		
		if (registrationResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.failInstance();
			return ResponseEntity.ok(response);
		}
	}
	
	@PutMapping
	@ApiDescription("커뮤니티 글 수정")
	public ResponseEntity<Response> modifyCommunity(CommunityDto communityDto, @AuthenticationPrincipal User user) {
		communityDto.setMemNo(user.getMemNo());
		int modifyResult = communityService.modifyCommunityContent(communityDto);
		
		if (modifyResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.failInstance();
			return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping
	@ApiDescription("커뮤니티 글 삭제")
	public ResponseEntity<Response> deleteCommunity(@RequestParam("comNo") int comNo, @AuthenticationPrincipal User user) {
		int deleteResult = communityService.deleteCommunityContent(comNo, user.getMemNo());
		
		if (deleteResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.failInstance();
			return ResponseEntity.ok(response);
		}
	}
	
	@GetMapping("comment")
	@ApiDescription("커뮤니티 댓글 목록 조회")
	public ResponseEntity<Response> getCommunityComment(CommunityCommentDto communityCommentDto) {
		List<CommunityCommentDto> communityCommentList = communityService.getCommunityComment(communityCommentDto);
		Response response = Response.successInstance();
		response.setData(communityCommentList);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("my-comment")
	@ApiDescription("내 커뮤니티 댓글 목록 조회")
	public ResponseEntity<Response> getMyCommunityComment(CommunityCommentDto communityCommentDto, @AuthenticationPrincipal User user) {
		communityCommentDto.setMemNo(user.getMemNo());
		List<CommunityCommentDto> myCommunityCommentList = communityService.getMyCommunityComment(communityCommentDto);
		Response response = Response.successInstance();
		response.setData(myCommunityCommentList);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/comment/{comcNo}")
	@ApiDescription("댓글 개별 조회")
	public ResponseEntity<Response> getCommunityCommentTypePiece(@PathVariable("comcNo") int comcNo) {
		CommunityCommentDto communityCommentInfo = communityService.getCommunityCommentTypePiece(comcNo);
		Response response = Response.successInstance();
		response.setData(communityCommentInfo);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("comment")
	@ApiDescription("커뮤니티 댓글 등록")
	public ResponseEntity<Response> insertCommunityComment(CommunityCommentDto communityCommentDto, @AuthenticationPrincipal User user) {
		communityCommentDto.setMemNo(user.getMemNo());
		int registrationResult = communityService.insertCommunityComment(communityCommentDto);
		
		if (registrationResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.failInstance();
			return ResponseEntity.ok(response);
		}
	}
	
	@PutMapping("comment")
	@ApiDescription("커뮤니티 댓글 수정")
	public ResponseEntity<Response> modifyCommunityComment(CommunityCommentDto communityCommentDto, @AuthenticationPrincipal User user) {
		communityCommentDto.setMemNo(user.getMemNo());
		int modifyResult = communityService.modifyCommunityComment(communityCommentDto);
		
		if (modifyResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		}
	}
	
	@DeleteMapping("comment")
	@ApiDescription("커뮤니티 댓글 삭제")
	public ResponseEntity<Response> deleteCommunityComment(@RequestParam("comcNo") int comcNo) {
		int deleteResult = communityService.deleteCommunityComment(comcNo);
		
		if (deleteResult != 0) {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		} else {
			Response response = Response.successInstance();
			return ResponseEntity.ok(response);
		}
	}
		
}