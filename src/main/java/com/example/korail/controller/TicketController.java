package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicketController {

    @GetMapping("info_payment")
    public String info_payment() {
        return "/ticket_info/info_payment";
    }

    @GetMapping("info_refund")
    public String info_refund() {
        return "/ticket_info/info_refund";
    }

    @GetMapping("info_reservation")
    public String info_reservation() {
        return "ticket_info/info_reservation";
    }
}
