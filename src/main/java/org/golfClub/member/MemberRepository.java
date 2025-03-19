package org.golfClub.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByFirstName(String firstName);
    List<Member> findByLastName(String lastName);
    List<Member> findByFullName(String firstName, String lastName);
    List<Member> findByPhoneNumber(String phoneNum);
    List<Member> findByMemberStartDate(String memberStartDate);
}
