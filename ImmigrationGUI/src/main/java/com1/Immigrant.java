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
    private String patientType;

    int accessGranted = 0; //0 not granted 1 granted

    public Immigrant(String firstName, String lastName, String dob, String gender, String nationality, String address, String phoneNumber, String email, String patientType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.nationality = nationality;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.patientType = patientType;
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

    public String getPatientType() {
        return patientType;
    }

    public void setPatientType(String patientType) {
        this.patientType = patientType;
    }

    public int getAccessGranted() {
        return accessGranted;
    }

    public void setAccessGranted(int accessGranted) {
        this.accessGranted = accessGranted;
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
        System.out.println("Patient Type: " + patientType);
    }





}