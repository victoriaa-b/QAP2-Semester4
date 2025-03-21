package org.golfClub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.golfClub", "org.golfClub.tournament"})
public class GolfClubTournamentApplication {
    public static void main(String[] args) {
        SpringApplication.run(GolfClubTournamentApplication.class, args);
    }
}