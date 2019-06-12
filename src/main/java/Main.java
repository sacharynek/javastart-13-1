import company.Employee;
import company.EmployeeHandler;

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
    }
}
