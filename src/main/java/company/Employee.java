package company;

public class Employee {

    private String fName, lName, pesel, department;
    private int wage;


    Employee(String fName, String lName, String pesel, String department, int wage) {
        this.fName = fName;
        this.lName = lName;
        this.pesel = pesel;
        this.department = department;
        this.wage = wage;
    }

    String getDepartment() {
        return department;
    }

    int getWage() {
        return wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "imię='" + fName + '\'' +
                ", nazwisko='" + lName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dział='" + department + '\'' +
                ", pensja=" + wage +
                '}';
    }
}
