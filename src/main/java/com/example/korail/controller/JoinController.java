package com.example.korail.controller;

import com.example.korail.dto.MemberDto;
import com.example.korail.service.MailSendService;
import com.example.korail.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class JoinController {
    @Autowired
    MemberService memberService;

    @Autowired
    MailSendService mailSendService;

    @GetMapping("joinAuth")
    public String mailAuth(){
        return "join/join2";
    }


    @GetMapping("join")
    public String join(){
        return "join/join";
    }

    @PostMapping("join_proc")
    public String join_proc(Model model, MemberDto memberDto){
        int result = memberService.getJoinResult(memberDto);
        if(result == 1){
            model.addAttribute("join_result","ok");
            return "login/login1";
        }else {
            //회원가입 실패 페이지
        }

        return "join/join";
    }

    @GetMapping("joinpage")
    public String joinpage(HttpSession session, MemberDto memberDto){
        session.setAttribute("mvo",memberDto);
        return "join/joinpage";
    }

    @GetMapping("joinpolicy")
    public String joinpolicy(){
        return "join/joinpolicy";
    }

    @GetMapping("joinpolicy1")
    public String joinpolicy1(){
        return "join/joinpolicy1";
    }

}
