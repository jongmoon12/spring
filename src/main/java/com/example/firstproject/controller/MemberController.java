package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Slf4j

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

//    @GetMapping("/members/new")
//    public String newMemberForm() {
//        return "members/new";
//    }
    @GetMapping("/join")
    public String signUpPage(){
        return "members/new";
    }



    @PostMapping("/join")
    public String join(MemberForm form) {
        //  System.out.println(form.toString());
        log.info(form.toString());

        // 1. DTO를 엔티티로 변환
        Member member = form.toEntity();
        log.info(member.toString());

        // 2. 리파지터리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());
        return "";
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model){
        Member member = memberRepository.findById(id).orElse(null);
        model.addAttribute("member", member);
        return "members/show";
    }
    @GetMapping("/members")
    public String index(Model model){
        ArrayList<Member> memberEntityList = memberRepository.findAll();
        model.addAttribute("members", memberEntityList);
        return "members/index";
    }

}
