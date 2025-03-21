package org.golfClub.member;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member newMember) {
        return memberRepository.save(newMember);
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    // String
    public List<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }


    public List<Member> getMembersByPhoneNumber(String phoneNum) {
        return memberRepository.findByPhoneNum(phoneNum); // Correct method name here
    }

    public List<Member> getMembersByStartDate(String memberStartDate) {
        return memberRepository.findByMemberStartDate(memberStartDate); // This one is correct too
    }

    public List<Member> findMembersByTournamentStartDate(String tournamentStartDate) {
        return memberRepository.findByTournamentStartDate(tournamentStartDate);
    }
}
