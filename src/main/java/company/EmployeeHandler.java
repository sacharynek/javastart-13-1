package company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

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

    private Employee readEmployee(String line) {
        String[] employeeInTabForm = line.split(";");
        //tutaj zrobić buildera !!!!
        return new Employee(employeeInTabForm[0], employeeInTabForm[1], employeeInTabForm[2], employeeInTabForm[3], Integer.parseInt(employeeInTabForm[4]));
    }

    private String readFile(String fileName) {
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

    public double minPay(Employee[] employeeTab) {
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

    public void writeStatisticsToFile(Employee[] emptab, String fileName) throws IOException {

        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Średnia wypłata: " + avgPay(emptab));
        bw.newLine();
        bw.write("Najmniejsza wypłata: " + minPay(emptab));
        bw.newLine();
        bw.write("Największa wypłata: " + maxPay(emptab));
        bw.newLine();
        bw.write("Łączna liczba pracowników: " + emptab.length);
        bw.newLine();

        HashMap<String, Integer> mapa = employeesByDepartment(emptab);
        Set<String> dzialy = mapa.keySet();
        for (String dzial : dzialy) {
            bw.write("Liczba pracowników w dziale " + dzial + " : " + mapa.get(dzial));
            bw.newLine();
        }

        bw.newLine();

        bw.flush();

    }
}
