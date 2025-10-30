package com.example.library.controller;

import com.example.library.model.Member;
import com.example.library.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String getAllMember(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members/index";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("member", new Member("", "", "", ""));
        return "members/form";
    }

    @PostMapping
    public String addMember(@ModelAttribute Member member) {
        memberService.addMember(member);
        return "redirect:/members";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable String id) {
        memberService.removeMember(id);
        return "redirect:/members";
    }
}