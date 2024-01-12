package com.yedam.app.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("tv") // 컴포넌트에 등록된 이름과 다른 이름을 쓰고 싶을 때 정의해줘야함.
//@Component() 이렇게 쓸 거면 getbean에 .class 붙여줘야함.
public class SamsungTV implements TV {

	Speaker speaker; // 이 코드만 적으면 실행 오류 null 발생

//	@Autowired 사용하고자하는 방식에 따라서 붙이는 위치가 달라짐
	// 생성자 방식
	SamsungTV(Speaker speaker) {
		this.speaker = speaker;
	}

	// setter 방식
	SamsungTV() {
	} // 기본 생성자

	@Autowired
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public void on() {
		System.out.println("삼성 TV를 켰습니다.");
		speaker.on();
	}
}
