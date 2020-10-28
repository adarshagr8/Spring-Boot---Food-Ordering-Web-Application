package com.madhuram.web.entities;

public class Users{
	private Integer UserID;
	private String Name;
	private String EmailAddress;
	private String PhoneNumber;
	private Boolean Enabled;
	private String Authority;
	private String DOB;
	private String HouseNo;
	private String Street;
	private String Locality;
	private Integer Zipcode;
	private String Gender;
	private java.time.LocalDate CreatedDate;
	private String Password;
	public Integer getUserID() {
		return UserID;
	}
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailAddress() {
		return EmailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		EmailAddress = emailAddress;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public Boolean getEnabled() {
		return Enabled;
	}
	public void setEnabled(Boolean enabled) {
		Enabled = enabled;
	}
	
	public String getAuthority() {
		return Authority;
	}
	public void setAuthority(String authority) {
		Authority = authority;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getHouseNo() {
		return HouseNo;
	}
	public void setHouseNo(String houseNo) {
		HouseNo = houseNo;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	public String getLocality() {
		return Locality;
	}
	public void setLocality(String locality) {
		Locality = locality;
	}
	public Integer getZipcode() {
		return Zipcode;
	}
	public void setZipcode(Integer zipcode) {
		Zipcode = zipcode;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public java.time.LocalDate getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(java.time.LocalDate createdDate) {
		CreatedDate = createdDate;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	@Override
	public String toString() {
		return "Users [UserID=" + UserID + ", Name=" + Name + ", EmailAddress=" + EmailAddress + ", PhoneNumber="
				+ PhoneNumber + ", Enabled=" + Enabled + ", Authority=" + Authority + ", DOB=" + DOB + ", HouseNo="
				+ HouseNo + ", Street=" + Street + ", Locality=" + Locality + ", Zipcode=" + Zipcode + ", Gender="
				+ Gender + ", CreatedDate=" + CreatedDate + ", Password=" + Password + "]";
	}
	
	
	
	
}