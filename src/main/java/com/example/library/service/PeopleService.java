package com.example.library.service;

import com.example.library.model.Author;
import com.example.library.model.Member;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    private final AuthorRepository authorRepo;
    private final MemberRepository memberRepo;

    public PeopleService(AuthorRepository authorRepo, MemberRepository memberRepo) {
        this.authorRepo = authorRepo;
        this.memberRepo = memberRepo;
    }

    public List<Author> getAllAuthors() { return authorRepo.findAll(); }
    public Optional<Author> getAuthor(String id) { return authorRepo.findById(id); }
    public Author addAuthor(Author a) { return authorRepo.save(a); }
    public boolean deleteAuthor(String id) { return authorRepo.deleteById(id); }

    public List<Member> getAllMembers() { return memberRepo.findAll(); }
    public Optional<Member> getMember(String id) { return memberRepo.findById(id); }
    public Member addMember(Member m) { return memberRepo.save(m); }
    public boolean deleteMember(String id) { return memberRepo.deleteById(id); }
}