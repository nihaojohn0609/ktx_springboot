package com.example.korail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TrainController {

    @GetMapping("train_timetable")
    public String train_timetable() {
        return "/train_info/train_timetable";
    }

    @GetMapping("train_route_info")
    public String train_route_info() {
        return "/train_info/train_route_info";
    }
}
