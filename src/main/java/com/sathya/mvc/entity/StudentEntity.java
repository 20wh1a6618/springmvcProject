package com.sathya.mvc.entity;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "StudentDetails")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long studId;

    @Column(name = "sn")
    private String studName;

    private String studBranch;
    private String studClg;
    private String studPhoneNumber;
    private double studFee;
    private String studAddress;
    private double studScholarShip;
    private LocalDate joinedOn;
    private String joinedBy;
	public long getStudId() {
		return studId;
	}
	public void setStudId(long studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public String getStudBranch() {
		return studBranch;
	}
	public void setStudBranch(String studBranch) {
		this.studBranch = studBranch;
	}
	public String getStudClg() {
		return studClg;
	}
	public void setStudClg(String studClg) {
		this.studClg = studClg;
	}
	public String getStudPhoneNumber() {
		return studPhoneNumber;
	}
	public void setStudPhoneNumber(String studPhoneNumber) {
		this.studPhoneNumber = studPhoneNumber;
	}
	public double getStudFee() {
		return studFee;
	}
	public void setStudFee(double studFee) {
		this.studFee = studFee;
	}
	public String getStudAddress() {
		return studAddress;
	}
	public void setStudAddress(String studAddress) {
		this.studAddress = studAddress;
	}
	public double getStudScholarShip() {
		return studScholarShip;
	}
	public void setStudScholarShip(double studScholarShip) {
		this.studScholarShip = studScholarShip;
	}
	public LocalDate getJoinedOn() {
		return joinedOn;
	}
	public void setJoinedOn(LocalDate joinedOn) {
		this.joinedOn = joinedOn;
	}
	public String getJoinedBy() {
		return joinedBy;
	}
	public void setJoinedBy(String joinedBy) {
		this.joinedBy = joinedBy;
	}
    
    
}
