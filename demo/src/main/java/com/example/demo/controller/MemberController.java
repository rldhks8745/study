package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Member;
import com.example.demo.repo.MemberRepository;

@RestController
@RequestMapping(value="/api")
public class MemberController {

	@Autowired
	MemberRepository memberRepository;
	
	@GetMapping("/member/{id}")
	public Member getMember( @PathVariable Long id ) throws NoSuchElementException {
		try {
			return memberRepository.findById(id).get();	
		} catch( NoSuchElementException e ) {
			throw new NoSuchElementException("존재하지않는 ID 입니다.");
		} 
	}
	
	@GetMapping("/member")
	public void addMember() {
        Member member = new Member();
        member.setName("andrew");
        member.setAge(32);
        memberRepository.save(member);
	}
	

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
