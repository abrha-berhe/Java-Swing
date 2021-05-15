package Model;

import java.time.LocalDate;
import java.time.Period;

public class SalariedStaff extends Staff{
    private int salary;
    public SalariedStaff() {
        super();
    }

    public SalariedStaff(String type, String firstName, String lastName, String ssn, int age, double annualPay) {
        super(type, firstName, lastName, ssn, age, annualPay);
        this.salary = salary;

    }
    public double calculateUnpaidOffDeduction(int extraDays){
        double deduction=0;
        if(extraDays>0) {
            deduction =extraDays * getAnnualPay() / 365 * 1.0;
        }
        return deduction;
    }
}
