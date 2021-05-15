package Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Employee {
    private String type;
    private String firstName;
    private String lastName;
    private String ssn;
    private int age;
    private double annualPay;
    private int givenTimeOffDays;
    private LocalDate leaveStartDate;
    private LocalDate leaveEndDate;

    public Employee(){

    }
    public Employee(String type,String firstName, String lastName, String ssn, int age, double annualPay) {
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.age = age;
        this.annualPay = annualPay;

    }
    @Override
    public String toString() {
        return this.type + "," + this.firstName + "," + this.lastName + "," + this.ssn +
                "," + this.age + "," + this.annualPay + ",";
    }
    public abstract double calculateUnpaidOffDeduction(int extraDays);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAnnualPay() {
        return annualPay;
    }

    public void setAnnualPay(double annualPay) {
        this.annualPay = annualPay;
    }

    public int getGivenTimeOffDays() {
        return givenTimeOffDays;
    }

    public void setGivenTimeOffDays(int givenTimeOffDays) {
        this.givenTimeOffDays = givenTimeOffDays;
    }

    public LocalDate getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(LocalDate leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public LocalDate getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(LocalDate leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    
    
}
