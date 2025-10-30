package com.example.library.repository;

import com.example.library.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository extends InMemoryRepository<Member> {

    @Override
    protected String getId(Member author) {
        return author.getId();
    }

    @Override
    protected void setId(Member author, String id) {
        author.setId(id);
    }

}