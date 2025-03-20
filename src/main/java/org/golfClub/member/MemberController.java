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

    @Autowired
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<Member> addNewMember (@RequestBody Member member) {
        Member savedMember = memberService.addMember(member);
        return new ResponseEntity<>(savedMember, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMember(@PathVariable Long id) {
        if (!memberService.checkIfMemberExist(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        memberService.deleteMemberById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberByTheirId(@PathVariable Long id) {
        Optional<Member> member = memberService.getMemberByMemberId(id);
        return member.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Name
    @GetMapping("/search/firstname/{firstName}")
    public ResponseEntity<List<Member>> findByFirstName(@PathVariable String firstName) {
        List<Member> members = memberService.getMembersByFirstName(firstName);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/search/lastname/{lastName}")
    public ResponseEntity<List<Member>> findByLastName(@PathVariable String lastName) {
        List<Member> members = memberService.getMembersByLastName(lastName);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    // check to see if it takes two
    @GetMapping("/search/fullName")
    public ResponseEntity<List<Member>> findByFullName(@RequestParam String firstName, @RequestParam String lastName) {
        List<Member> members = memberService.getMembersByFullName(firstName, lastName);
        return new ResponseEntity<>(members, HttpStatus.OK);
    }





}
