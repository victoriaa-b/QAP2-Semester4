package org.golfClub.tournament;

import org.golfClub.member.Member;
import org.golfClub.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TournamentService {

    TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;


    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public List<Tournament> getTournamentByStartDate(LocalDate startDate) {
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> getTournamentByLocation(String location) {
        return tournamentRepository.findByLocation(location);
    }

    public Tournament getTournamentByParticipantsAndId(Long tournamentId) {
        return tournamentRepository.findById(tournamentId).orElse(null);
    }

    public Tournament addTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }


    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament addMemberToTournament(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElse(null);
        Member member = memberRepository.findById(memberId).orElse(null);

        if (tournament != null && member != null) {
            tournament.addParticipant(member);
            return tournamentRepository.save(tournament);
        }
        return null;
    }
}