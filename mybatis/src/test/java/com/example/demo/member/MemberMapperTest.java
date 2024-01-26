package com.example.demo.member;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.member.mapper.MemberMapper;

@SpringBootTest
public class MemberMapperTest {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Test
	public void 멤버조회() {
		String id = "K001";
		MemberVO vo = memberMapper.getMember(id);
		System.out.println(vo);;
		assertThat(vo.getMid()).isEqualTo(id);
	}
}	
