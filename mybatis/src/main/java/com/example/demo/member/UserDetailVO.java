package com.example.demo.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserDetailVO implements UserDetails{
	
	final MemberVO memberVO;
	
//	public UserDetailVO() {}
//	
//	public UserDetailVO(MemverVO memberVO) {
//		this.memberVO = memberVO;
//	}
//	
//	public void setMemberVO(MemberVO memberVO) {
//		this.memberVO = memberVO;
//	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(memberVO.getResponsbility()));
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return memberVO.getPass();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return memberVO.getMid();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	} // 계정 막기

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	} // 제제회원 ex) 일주일간 정지

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
