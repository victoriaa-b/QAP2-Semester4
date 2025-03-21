package org.golfClub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    // find all members
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

    @GetMapping("/search/start-date")
    public ResponseEntity<List<Member>> findByMemberStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        List<Member> members = memberService.getMembersByStartDate(startDate);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // took out first and last name
    @GetMapping("/search/name/{name}")
    public ResponseEntity<List<Member>> findByName(@PathVariable String name) {
        List<Member> members = memberService.getMembersByName(name);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // changed from string to local date
    @GetMapping("/search/tournament-start-date/{tournamentStartDate}")
    public ResponseEntity<List<Member>> findByTournamentStartDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate tournamentStartDate) {
        List<Member> members = memberService.getMembersByTournamentStartDate(tournamentStartDate);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }
}
