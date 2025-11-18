package com.example.library.service;

import com.example.library.model.Member;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void addMember(Member member) {
        memberRepository.save(member);
    }

    public void updateMember(String id, Member update) {
        update.setId(id);
        memberRepository.save(update);
    }

    public void removeMember(String memberId) {
        Member member = memberRepository.findById(memberId);
        if (member != null) {
            memberRepository.delete(member);
        }
    }

    public Member getMemberById(String memberId) {
        return memberRepository.findById(memberId);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

}
