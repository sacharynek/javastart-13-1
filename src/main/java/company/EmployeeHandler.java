package company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class EmployeeHandler {

    public Employee[] fileToEmployeeArray(String fileName) {
        String textFromFile = readFile(fileName);
        String[] lines = textFromFile.split("\n");

        Employee[] employeeTab = new Employee[lines.length];
        for (int i = 0; i < employeeTab.length; i++) {
            employeeTab[i] = readEmployee(lines[i]);
        }
        return employeeTab;
    }

    public Employee readEmployee(String line) {
        String[] employeeInTabForm = line.split(";");
        //tutaj zrobić buildera !!!!
        return new Employee(employeeInTabForm[0], employeeInTabForm[1], employeeInTabForm[2], employeeInTabForm[3], Integer.parseInt(employeeInTabForm[4]));
    }

    public String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(file);) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("plik nie istnieje");
        }

        return sb.toString();
    }

    public double avgPay(Employee[] employeeTab) {
        int sum = 0;
        for (Employee emp : employeeTab) {
            sum += emp.getPensja();
        }
        return sum * 1.0 / employeeTab.length;
    }

    public int minPay(Employee[] employeeTab) {
        int min = employeeTab[0].getPensja();
        for (Employee emp : employeeTab) {
            if (emp.getPensja() < min) {
                min = emp.getPensja();
            }
        }

        return min;
    }

    public double maxPay(Employee[] employeeTab) {
        int max = 0;
        for (Employee emp : employeeTab) {
            if (emp.getPensja() > max) {
                max = emp.getPensja();
            }
        }

        return max;
    }

    public HashMap<String, Integer> employeesByDepartment(Employee[] employeeTab) {
        HashMap<String, Integer> output = new HashMap<String, Integer>();

        for (Employee emp : employeeTab) {
            if (!output.containsKey(emp.getDział())) {
                output.put(emp.getDział(), 1);
            } else {
                int currentVal = output.get(emp.getDział());
                output.put(emp.getDział(), ++currentVal);
            }
        }

        return output;

    }

}
