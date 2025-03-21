package org.golfClub.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    private final TournamentService tournamentService;

   @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    // Start date
    @GetMapping("/search/startDate")
    public ResponseEntity<List<Tournament>> getTournamentsByStartDate(@RequestParam LocalDate startDate) {
        List<Tournament> tournaments = tournamentService.getTournamentByStartDate(startDate);
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    // location
    @GetMapping("/search/location/{location}")
    public ResponseEntity<List<Tournament>> getTournamentsByLocation(@PathVariable String location) {
        List<Tournament> tournaments = tournamentService.getTournamentByLocation(location);
        return new ResponseEntity<>(tournaments, HttpStatus.OK);
    }

    @GetMapping("/{id}/participants")
    public ResponseEntity<Tournament> getTournamentWithParticipants(@PathVariable Long id) {
        Tournament tournament = tournamentService.getTournamentByParticipantsAndId(id);
        return tournament != null ? ResponseEntity.ok(tournament)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    // maybe delete tournament?
    @PostMapping
    public ResponseEntity<Tournament> addTournament(@RequestBody Tournament tournament) {
        Tournament savedTournament = tournamentService.addTournament(tournament);
        return new ResponseEntity<>(savedTournament, HttpStatus.CREATED);
    }
}