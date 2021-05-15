package Model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Staff extends Employee{


    public Staff() {
    }

    public Staff(String type, String firstName, String lastName, String ssn, int age, double annualPay) {
        super(type, firstName, lastName, ssn, age, annualPay);
    }

    public abstract double calculateUnpaidOffDeduction(int extraDays);
}
