package com.community.api.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User implements UserDetails {
	
	private static final long serialVersionUID = 1223263906145274107L;
	
	private int memNo;
	private String memId;
	private String memPw;
	private String memName;
	private String memNickname;
	private String memEmail;
	private String memPhone;
	private String memRole;
	private String memDatetime;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(this.memRole));
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return this.memPw;
	}
	
	@Override
	public String getUsername() {
		return this.memId;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return false;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return false;
	}
	
	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}
	
	@Override
	public boolean isEnabled() {
		return false;
	}
	

}