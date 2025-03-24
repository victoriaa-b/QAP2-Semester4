package org.golfClub.member;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.golfClub.tournament.Tournament;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "members")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private String phoneNum;
    private String address;
    private LocalDate membershipStartDate; // could be date?
    @Column
    private int membershipLength;

    @ManyToMany(mappedBy = "participants")
    private Set<Tournament> tournaments = new HashSet<>();

    // Constructors
    public Member(){

    }

    public Member(String name, String email, String phoneNum, String address, LocalDate membershipStartDate, int membershipLength){
        this.name = name;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.membershipStartDate = membershipStartDate;
        this.membershipLength = membershipLength;
    }

    // Getters and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPhoneNum(){
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum){
        this.phoneNum = phoneNum;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate memberStartDate){
        this.membershipStartDate = memberStartDate;
    }

    public int getMembershipLength() {
        return membershipLength;
    }

    public void setMembershipLength(int membershipLength) {
        this.membershipLength = membershipLength;
    }

    // add and get new members and tournaments
    // add members to tournaments
    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }


}
