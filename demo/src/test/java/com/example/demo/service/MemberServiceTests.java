package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Member;
import com.example.demo.repo.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest // @RunWith(SpringRunner.class)가 등록되어아햠
@Rollback(true)
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MemberServiceTests {

	@Autowired
	private MemberRepository memberRepository;
	
	@Before
	public void before() {
		log.info("@Before");
        //given
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        memberRepository.save(member);
	}
	
	@After
	public void after() {
		log.info("@After");
	}

	@Test // org.junit.Test; import 해야함
	public void test1() {
		System.out.println(1);
		
        // when
        Member retrivedMember = memberRepository.findById(1L).get();

        // then
        assertEquals(retrivedMember.getName(), "andrew");
        assertEquals(retrivedMember.getAge(), Integer.valueOf(32));
	}
	
	@Test(expected = NoSuchElementException.class)
	public void test2() {
		System.out.println(2);

        // when
        Member retrivedMember = memberRepository.findById(10L).get();

        // then
        assertEquals(retrivedMember.getName(), "andrew");
        assertEquals(retrivedMember.getAge(), Integer.valueOf(32));
	}
	
	@Test
	public void test3() {
		System.out.println(3);

        // when
        Member retrivedMember = memberRepository.findById(3L).get();

        // then
        assertEquals(retrivedMember.getName(), "andrew");
        assertEquals(retrivedMember.getAge(), Integer.valueOf(32));
	}
	
}
