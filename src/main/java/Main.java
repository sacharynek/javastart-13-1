import company.Employee;
import company.EmployeeHandler;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EmployeeHandler eh = new EmployeeHandler();
        Employee[] emptab = eh.fileToEmployeeArray("pliczek.txt");

        System.out.println(Arrays.toString(emptab));

        System.out.println(eh.minPay(emptab));
        System.out.println(eh.maxPay(emptab));
        System.out.println(eh.avgPay(emptab));
        System.out.println(eh.employeesByDepartment(emptab));

        try {
            eh.writeStatisticsToFile(emptab, "pliczek1.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
