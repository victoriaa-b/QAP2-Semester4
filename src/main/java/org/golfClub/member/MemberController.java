package org.golfClub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/allMembers")
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }

    @PostMapping
    public ResponseEntity<Member> addNewMember (@RequestBody Member member) {
        Member savedMember = memberService.addMember(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }


    @GetMapping("/search/phone/{phoneNum}")
    public ResponseEntity<List<Member>> findByPhoneNumber(@PathVariable String phoneNum) {
        List<Member> members = memberService.getMembersByPhoneNumber(phoneNum);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }


    @GetMapping("/search/start-date/{memberStartDate}")
    public ResponseEntity<List<Member>> findByMemberStartDate(@PathVariable String memberStartDate) {
        List<Member> members = memberService.getMembersByStartDate(memberStartDate);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Member>> findByName(@PathVariable String name) {
        List<Member> members = memberService.getMembersByName(name);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/search/tournament-start-date/{tournamentStartDate}")
    public ResponseEntity<List<Member>> findByTournamentStartDate(@PathVariable String tournamentStartDate) {
        List<Member> members = memberService.findMembersByTournamentStartDate(tournamentStartDate);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }


}
