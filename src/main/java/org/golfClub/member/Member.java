package org.golfClub.member;
import org.golfClub.tournament.Tournament;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "memebers")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column
    private String firstName;
    @Column
    private String lastName;
    private String email;
    private String phoneNum;
    private String address;
    @Column
    private String memberStartDate; // could be date?
    @Column
    private int membershipLength;

    // CHECK ON THIS
    @ManyToMany(mappedBy = "participants")
    private Set<Tournament> tournaments = new HashSet<>();

    // Constructors
    public Member(){

    }

    public Member(String firstName, String lastName, String email, String phoneNum, String address, String memberStartDate, int membershipLength){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.memberStartDate = memberStartDate;
        this.membershipLength = membershipLength;
    }

    // Getters and Setters
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
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

    public String getMemberStartDate() {
        return memberStartDate;
    }

    public void setMemberStartDate(String memberStartDate {
        this.memberStartDate = memberStartDate;
    }

    public int getMembershipLength() {
        return membershipLength;
    }

    public void setMembershipLength(int membershipLength) {
        this.membershipLength = membershipLength;
    }


}
