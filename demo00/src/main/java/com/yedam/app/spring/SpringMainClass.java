package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		// java와 다르게 코드를 수정하지 않고 xml파일에 class명만 바꿔주면 됨.
		System.out.println("Spring 방식");

		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

		TV tv = (TV) ctx.getBean("tv");
//		TV tv = (TV) ctx.getBean(TV.class); @Component() 이렇게 쓸 때 사용
		tv.on();
	}

}
