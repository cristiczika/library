package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends InMemoryRepository<Member> {

    @Override
    protected String getId(Member member) {
        return member.getId();
    }

    @Override
    protected void setId(Member member, String id) {
        member.setId(id);
    }

}