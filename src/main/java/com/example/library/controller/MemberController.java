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

    /*
    getAll si getById
     */
    @GetMapping
    public String getAllMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "members/index";
    }

    @GetMapping("/{id}")
    public String getMemberById(@PathVariable String id, Model model) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            return "redirect:/members";
        }

        model.addAttribute("member", member);
        return "members/details";
    }


    /*
    addMember
     */
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


    /*
    updateMember
     */
    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable String id, Model model) {
        Member member = memberService.getMemberById(id);
        if (member == null) {
            return "redirect:/members";
        }

        model.addAttribute("member", member);
        return "members/form";
    }

    @PostMapping("/{id}/edit")
    public String updateMember(@PathVariable String id, @ModelAttribute Member updatedMember) {
        memberService.updateMember(id, updatedMember);
        return "redirect:/members";
    }


    /*
    deleteMember
     */
    @PostMapping("/{id}/delete")
    public String deleteMember(@PathVariable String id) {
        memberService.removeMember(id);
        return "redirect:/members";
    }
}