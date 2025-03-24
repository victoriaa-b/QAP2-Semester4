package org.golfClub.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByPhoneNum(String phoneNum);
    List<Member> findByMembershipStartDate(LocalDate startDate);
    List<Member> findByTournamentsStartDate(LocalDate tournamentStartDate);
}

