package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Member;
import com.example.demo.repo.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 실제 서블릿 컨테이너 구동 후 테스트를 위해
public class MemberControllerTests {

	@Autowired
	TestRestTemplate trt;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Before
	public void setup() {		
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        memberRepository.save(member);
	}
	
	@Test // org.junit.Test; import 해야함
	public void test1() throws Exception {
		String result = trt.getForObject("/api/member/1", String.class);
		
		assertThat(result).contains("andrew");
	}
	
	@Test
	public void test2() throws Exception {
		String result = trt.getForObject("/api/hello", String.class);
		
		assertThat(result).isEqualTo("hello");
	}
}
