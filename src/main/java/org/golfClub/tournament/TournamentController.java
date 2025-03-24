package org.golfClub.tournament;

import org.golfClub.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @PostMapping
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        return ResponseEntity.ok(tournamentService.addTournament(tournament));
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Tournament tournament = tournamentService.tournamentRepository.findById(id).orElse(null);
        if (tournament == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tournament);
    }

    @GetMapping("/search/startDate")
    public List<Tournament> getTournamentsByStartDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate) {
        return tournamentService.getTournamentByStartDate(startDate);
    }


    // find tournament by location
    @GetMapping("/search/location")
    public List<Tournament> getTournamentsByLocation(@RequestParam String location) {
        return tournamentService.getTournamentByLocation(location);
    }

    @GetMapping("/{tournamentId}/members")
    public Set<Member> getTournamentParticipants(@PathVariable Long tournamentId) {
        Tournament tournament = tournamentService.getTournamentByParticipantsAndId(tournamentId);
        return tournament.getParticipants();
    }

   // Add member to tournament
    @PostMapping("/{tournamentId}/members/{memberId}")
    public ResponseEntity<Tournament> addMemberToTournament(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId) {
        Tournament tournament = tournamentService.addMemberToTournament(tournamentId, memberId);
        if (tournament == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tournament);
    }
}