package com.sathya.mvc.model;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel 
{
	@NotEmpty(message = "Student Name is required")
	private String studName;
	@NotEmpty(message = "Student Branch is required")
	private  String studBranch;
	@NotEmpty(message = "Student College is required")
	private String studClg;
	@Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits")
	private String studPhoneNumber;	
	@NotNull(message = "Fee is required")
    @Positive(message = "Fee must be a positive number")
    private double studFee;  
	@NotEmpty(message = "Student Address is required")
    private String studAddress;
    //private String proImage;
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
	     
}
