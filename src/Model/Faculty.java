package Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Faculty extends Employee{
    public Faculty() {
    }
    public Faculty(String type, String firstName, String lastName, String ssn, int age, double annualPay) {
        super(type, firstName, lastName, ssn, age, annualPay);
    }
    public String toString(){
        return super.toString();

    }
    public abstract double calculateUnpaidOffDeduction(int extraDays);
}
