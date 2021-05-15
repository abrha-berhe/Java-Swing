package Model;

import java.time.LocalDate;
import java.time.Period;

public class AssociateProfessor extends Faculty{

    public AssociateProfessor(){
        super();
    }

    public AssociateProfessor(String type, String firstName, String lastName, String ssn, int age, double annualPay) {
        super(type, firstName, lastName, ssn, age, annualPay);
    }

    public double calculateUnpaidOffDeduction(int extraDays){
        double deduction=0;
        if(extraDays>0) {
            deduction =extraDays * getAnnualPay() / 365 * 1.3;
        }
        return deduction;
    }

}
