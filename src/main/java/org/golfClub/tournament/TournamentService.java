package org.golfClub.tournament;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;
    // start date
    // locattion
    // find tournament and participants
    public List<Tournament> getTournamentByStartDate(LocalDate startDate) { // fixed error
        return tournamentRepository.findByStartDate(startDate);
    }

    public List<Tournament> getTournamentByLocation(String location){
        return tournamentRepository.findByLocation(location);
    }

    public Tournament getTournamentByParticipantsAndId(Long tournamentId){
        return tournamentRepository.findByIdAndParticipants(tournamentId);
    }

}
