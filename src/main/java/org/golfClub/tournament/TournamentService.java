package org.golfClub.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public TournamentService() {
        // Default constructor
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
}