package Controller;

import Model.AssociateProfessor;
import Model.AssistantProfessor;
import Model.SalariedStaff;
import Model.Professor;
import Model.HourlyStaff;
import Model.Employee;
import Model.Instructor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import static java.time.LocalDate.from;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PayrollManager {

    ArrayList<Employee> employees = new ArrayList<>();

    public void registerEmployee(Employee e) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./employees.txt", true));
            writer.write(e.toString());
            writer.newLine();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

     
    
    public ArrayList<Employee> readEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        String type = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("./employees.txt"));
            String line = reader.readLine().trim();

            while (line != null) {
                String[] splittedLine = line.split(",");
                type = splittedLine[0];
                String firstName = splittedLine[1];
                String lastName = splittedLine[2];
                String ssn = splittedLine[3];
                int age = Integer.parseInt(splittedLine[4]);
                double pay = Double.parseDouble(splittedLine[5]);
                if (type.equalsIgnoreCase("instructor")) {
                    Employee instructor = new Instructor(type, firstName, lastName, ssn, age, pay);
                    employees.add(instructor);
                } else if (type.equalsIgnoreCase("assistantProfessor")) {
                    Employee assistantProfessor = new AssistantProfessor(type, firstName, lastName, ssn, age, pay);
                    employees.add(assistantProfessor);
                } else if (type.equalsIgnoreCase("associateProfessor")) {
                    Employee associateProfessor = new AssociateProfessor(type, firstName, lastName, ssn, age, pay);
                    employees.add(associateProfessor);
                } else if (type.equalsIgnoreCase("professor")) {
                    Employee professor = new Professor(type, firstName, lastName, ssn, age, pay);
                    employees.add(professor);
                } else if (type.equalsIgnoreCase("hourlyStaff")) {
                    Employee hourlyStaff = new HourlyStaff(type, firstName, lastName, ssn, age, pay);
                    employees.add(hourlyStaff);
                } else if (type.equalsIgnoreCase("salariedStaff")) {
                    Employee salariedStaff = new SalariedStaff(type, firstName, lastName, ssn, age, pay);
                    employees.add(salariedStaff);
                }
                line = reader.readLine();
            }
            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return employees;
    }

    public void deleteEmployee(String socialSecurityNum) {
        ArrayList<Employee> employees = readEmployee();
         this.fileResetter();
        for (Employee m : employees) {
            if (m.getSsn().equalsIgnoreCase(socialSecurityNum)) {
                continue;
            }
            this.registerEmployee(m);
        }       
    }
    
    public void fileResetter(){
     try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./employees.txt", false));
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public Employee mostPaid() {
        ArrayList<Employee> employees = readEmployee();
        double highestPay = employees.get(0).getAnnualPay();
        int position = -1;
        for (int i = 0; i < employees.size(); i++) {
            if (highestPay <= employees.get(i).getAnnualPay()) {
                highestPay = employees.get(i).getAnnualPay();
                position = i;
            }
        }
       
        return employees.get(position);
    }

    public double calculateAverageSalary() {
        ArrayList<Employee> employees = readEmployee();
        int sum = 0;
        for (int i = 0; i < employees.size(); i++) {
            sum += employees.get(i).getAnnualPay();
        }
        double averageSalary = (double) sum / employees.size();
        return averageSalary;
    }

    public double timeOffDeduction(Employee e, LocalDate leaveStartDate, LocalDate leaveEndDate) {
        if (leaveStartDate != null && leaveEndDate != null) {
            int differenceDay = (int)ChronoUnit.DAYS.between(leaveStartDate, leaveEndDate);//Period.between(leaveStartDate, leaveEndDate).getDays();
            int extraDays = differenceDay - e.getGivenTimeOffDays();
            double extraDaysOfDeduction = 0;
            if (e instanceof Instructor && differenceDay > 10) {
                extraDays = (int) differenceDay - 10;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else if (e instanceof AssistantProfessor && differenceDay > 14) {
                extraDays = (int) differenceDay - 14;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else if (e instanceof AssociateProfessor && differenceDay > 21) {
                extraDays = (int) differenceDay - 21;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else if (e instanceof Professor && differenceDay > 28) {
                extraDays = (int) differenceDay - 28;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else if (e instanceof HourlyStaff && differenceDay > 5) {
                extraDays = (int) differenceDay - 5;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else if (e instanceof AssistantProfessor && differenceDay > 7) {
                extraDays = (int) differenceDay - 7;
                extraDaysOfDeduction = e.calculateUnpaidOffDeduction(extraDays);
                return extraDaysOfDeduction;
            } else {
                return 0;
            }
        } else {
            return 0.0;
        }
    }

    public double taxDeduction(Employee e) {
        double taxDeduction;
        double netSalaryBeforeTax = e.getAnnualPay();
        if (e.getAnnualPay() > 120000) {
            taxDeduction = netSalaryBeforeTax * 0.30;
        } else if (netSalaryBeforeTax > 90000) {
            taxDeduction = netSalaryBeforeTax * 0.20;
        } else if (netSalaryBeforeTax > 70000) {
            taxDeduction = netSalaryBeforeTax * 0.15;
        } else if (netSalaryBeforeTax > 50000) {
            taxDeduction = netSalaryBeforeTax * 0.10;
        } else {
            taxDeduction = 0;
        }
        return taxDeduction;
    }

    public double calculateNetSalary(Employee e, LocalDate leaveStartDate, LocalDate leaveEndDate) {
        double netSalaryAfterTax = e.getAnnualPay() - timeOffDeduction(e, leaveStartDate, leaveEndDate) - taxDeduction(e);
        return netSalaryAfterTax;
    }

}
