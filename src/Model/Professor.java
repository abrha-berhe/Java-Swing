package Model;

import java.time.LocalDate;
import java.time.Period;

public class Professor extends Faculty{

    public Professor(){
        super();
    }
    public Professor(String type, String firstName, String lastName, String ssn, int age, double annualPay) {
        super(type, firstName, lastName, ssn, age, annualPay);
    }

    public String toString(){
        return super.toString();
    }
    public double calculateUnpaidOffDeduction(int extraDays){
        double deduction=0;
        if(extraDays>0) {
            deduction =extraDays * getAnnualPay() / 365 * 1.2;
        }
        return deduction;
    }

}
