package org.golfClub.member;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

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

    public List<Member> getMembersByName(String name) {
        return memberRepository.findByName(name);
    }

    public List<Member> getMembersByPhoneNumber(String phoneNum) {
        return memberRepository.findByPhoneNum(phoneNum);
    }

    public List<Member> getMembersByStartDate(LocalDate startDate) {
        return memberRepository.findByMemberStartDate(startDate);
    }

    public List<Member> getMembersByTournamentStartDate(LocalDate tournamentStartDate) {
        return memberRepository.findByTournamentsStartDate(tournamentStartDate);
    }
}
