package View;

import Model.Employee;
import Model.Instructor;
import Controller.PayrollManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        PayrollManager pm = new PayrollManager();

        Employee e = new Instructor("instructor", "Abraha","Gebre","390",28, 60000);
        Employee e1 = new Instructor("instructor", "Abraha","Gebre","391",28, 110000);
        Employee e2 = new Instructor("instructor", "Abraha","Gebre","392",28, 140000);
        Employee e3 = new Instructor("instructor", "Abraha","Gebre","393",28, 91000);
        pm.registerEmployee( e );
        pm.registerEmployee( e1 );
        pm.registerEmployee( e2 );
        pm.registerEmployee( e3 );
        LocalDate ld = LocalDate.of( 2021, 11, 1 );
        LocalDate ld1 = LocalDate.of( 2021, 11, 30 );
        //System.out.println(Period.between( ld,ld1 ));
        //System.out.println(pm.taxDeduction( e ));
        //System.out.println(pm.calculateNetSalary( e, ld, ld1 ));


        //pm.readEmployee();
        //print
        pm.deleteEmployee( "392" );
        System.out.println(pm.taxDeduction( e ));
        System.out.println(pm.timeOffDeduction( e,ld, ld1 ));
        System.out.println( pm.calculateNetSalary( e, ld, ld1 ));


    }
}
