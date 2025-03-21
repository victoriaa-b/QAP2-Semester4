package org.golfClub.tournament;

import org.golfClub.member.Member;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tournaments")
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Column
    private LocalDate startDate; // changed from striing
    @Column
    private LocalDate endDate; // changed from string
    private String location;
    private double entryFee;
    private double cashPrizeAmt;

    @ManyToMany
    @JoinTable(
            name = "tournament_participants",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )

    private Set<Member> participants = new HashSet<>();

    // Constructors
    public Tournament(){
    }

    public Tournament(LocalDate startDate, LocalDate endDate, String location, double entryFee,double cashPrizeAmt){
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrizeAmt = cashPrizeAmt;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public double getCashPrizeAmt() {
        return cashPrizeAmt;
    }

    public void setCashPrizeAmt(double cashPrizeAmt) {
        this.cashPrizeAmt = cashPrizeAmt;
    }

    // Check this logic
    public Set<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Member> participants) {
        this.participants = participants;
    }

    public void addParticipant(Member member) {
        this.participants.add(member);
        member.getTournaments().add(this);
    }

}
