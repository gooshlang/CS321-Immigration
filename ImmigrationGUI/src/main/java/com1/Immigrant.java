package com1;

public class Immigrant {
    private String firstName;
    private String lastName;
    private String dob;
    private String gender;
    private String nationality;
    private String address;
    private String phoneNumber;
    private String email;
    private String dependent;
    private String FirstNameDependent;
    private String LastNameDependent;

    private int visaID;
    private int accessGranted = 0; //0 not granted 1 granted ADAM
    private int approval = 0; //0 not granted 1 granted MATT

    public Immigrant(String firstName, String lastName, String dob, String gender, String nationality, String address, String phoneNumber, String email, String dependent, String firstNameDependent, String lastNameDependent, int visaID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dependent = dependent;
        FirstNameDependent = firstNameDependent;
        LastNameDependent = lastNameDependent;
        this.visaID = visaID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDependent() {
        return dependent;
    }

    public void setDependent(String dependent) {
        this.dependent = dependent;
    }

    public int getAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(int accessGranted) {
        this.accessGranted = accessGranted;
    }

    public int getVisaID() {
        return visaID;
    }

    public void setVisaID(int visaID) {
        this.visaID = visaID;
    }

    public String getFirstNameDependent() {
        return FirstNameDependent;
    }

    public void setFirstNameDependent(String firstNameDependent) {
        FirstNameDependent = firstNameDependent;
    }

    public String getLastNameDependent() {
        return LastNameDependent;
    }

    public void setLastNameDependent(String lastNameDependent) {
        LastNameDependent = lastNameDependent;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }

    public void printInformation() {
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Nationality: " + nationality);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
        System.out.println("Patient Type: " + dependent);
    }





}