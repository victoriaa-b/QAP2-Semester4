package org.golfClub.member;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

// save - delete - add - all
//
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    // Id - might be more - check
    public Optional<Member> getMemberByMemberId(Long id) {
        return memberRepository.findById(id);
    }

    public Member addMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);
    }

    public boolean checkIfMemberExist(Long id) {
        return memberRepository.existsById(id);
    }

    // String
    public List<Member> getMembersByFirstName(String firstName) {
        return memberRepository.findByFirstName(firstName);
    }

    public List<Member> getMembersByLastName(String lastName) {
        return memberRepository.findByLastName(lastName);
    }

    public List<Member> getMembersByFullName(String firstName, String lastName) {
        return memberRepository.findByFullName(firstName, lastName);
    }

    public List<Member> getMembersByPhoneNumber(String phoneNumber) {
        return memberRepository.findByPhoneNumber(phoneNumber);
    }

    public List<Member> getMembersByStartDate(String memberStartDate) {
        return memberRepository.findByMemberStartDate(memberStartDate);
    }

}
