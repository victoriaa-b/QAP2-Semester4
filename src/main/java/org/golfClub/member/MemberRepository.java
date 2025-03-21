package org.golfClub.member;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);
    List<Member> findByPhoneNum(String phoneNum);
    List<Member> findByMemberStartDate(String memberStartDate);
    List<Member> findByTournamentStartDate(@Param("startDate") String tournamentStartDate);
}
