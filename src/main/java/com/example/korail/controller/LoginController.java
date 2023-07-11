package com.example.korail.controller;

import com.example.korail.dto.MemberDto;
import com.example.korail.dto.ReservationDto;
import com.example.korail.dto.SessionDto;
import com.example.korail.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    MemberService memberService;

    @GetMapping("logout")
    public String logout(HttpSession session,Model model){
        SessionDto svo =(SessionDto)session.getAttribute("svo");
        if(svo != null){
            session.invalidate();
            model.addAttribute("logout_result","ok");
        }

        return "index";
    }

    @GetMapping("login2")
    public String reservation_login(){
        return "reservationlist/login2";
    }

    @GetMapping("login")
    public String login(){
        return "login/login1";
    }

    @PostMapping("login_proc")
    public String login_proc(MemberDto memberDto, Model model, HttpSession session, String userId) {
        ReservationDto rvo = (ReservationDto) session.getAttribute("rvo");
        SessionDto svo = memberService.getLoginResult(memberDto);
        System.out.println("svo-->" + svo);
        if (svo != null) {
            session.setAttribute("svo", svo);
            if (memberDto.getPagename().equals("mainlogin")) {
                model.addAttribute("login_result", "ok");
                System.out.println("로그인 성공");
                return "redirect:/train_reservation_rotinf";
            } else if (memberDto.getPagename().equals("reservation")) {
                rvo.setSeatNum(memberDto.getSeatNum());
                rvo.setTicketQty(memberDto.getTicketQty());
                rvo.setId(memberDto.getId());
                return "redirect:/train_reservation_stplcfmpym";
            } else if (memberDto.getPagename().equals("reservationlist")) {
                session.setAttribute("id", memberDto.getId());
                return "redirect:/reservation_main";
            } else if (memberDto.getPagename().equals("mylogin")) {
                return "redirect:/mypage";
            }
        }

        return "/login/login_fail";
    }

    @GetMapping("login_fail")
    public String login_fail(){
        return "login/login_fail";
    }
}
