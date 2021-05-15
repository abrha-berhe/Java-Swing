package Model;

import java.time.LocalDate;
import java.time.Period;

public class HourlyStaff extends Staff{
    private double hourlyRate;
    public HourlyStaff() {
        super();
    }
    public HourlyStaff(String type, String firstName, String lastName, String ssn, int age, double hourlyRate ) {
        super(type, firstName, lastName, ssn, age, hourlyRate*8.0*40*52);
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
    public double calculateUnpaidOffDeduction(int extraDays){
        double deduction=0;
        if(extraDays>0) {
            deduction =extraDays * hourlyRate * 8;
        }
        return deduction;
    }
}
