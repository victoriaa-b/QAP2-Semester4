package org.golfClub.tournament;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
    List<Tournament> findByStartDate(LocalDate startDate);
    List<Tournament> findByLocation(String location);

    // Use a simpler method that Spring Data JPA can auto-implement
    Optional<Tournament> findById(Long id);
}