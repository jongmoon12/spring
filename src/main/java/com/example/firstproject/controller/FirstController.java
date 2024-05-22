package com.example.firstproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") // url (/hi) 읽는다.
    public String niceToMeetYou(Model model) {
        model.addAttribute("username", "JongMoon");
        return "greetings";
        }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname", "JM");
        return "goodbye";
    }
}
