package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends InFileRepository<Member> {

    public MemberRepository() {
        super(Member.class, "members.json", "src/main/resources/data");
    }

    @Override
    protected String getId(Member member) {
        return member.getId();
    }

    @Override
    protected void setId(Member member, String id) {
        member.setId(id);
    }

}