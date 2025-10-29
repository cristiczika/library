package com.example.library.repository;

import com.example.library.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    private final List<Member> members = new ArrayList<>(Arrays.asList(
            new Member("M1", "Ana Popescu", "ana.popescu@gmail.com", "L1"),
            new Member("M2", "George Ionescu", "georgei@yahoo.com", "L1"),
            new Member("M3", "Maria Dobre", "maria_dobre@gmail.com", "L1")
    ));

    public List<Member> findAll() {
        return members;
    }

    public Optional<Member> findById(String id) {
        return members.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    public Member save(Member member) {
        members.removeIf(m -> m.getId().equals(member.getId()));
        members.add(member);
        return member;
    }

    public boolean deleteById(String id) {
        return members.removeIf(m -> m.getId().equals(id));
    }
}