package company;

public class Employee {

    private String imię, nazwisko, pesel, dział;
    private int pensja;


    public Employee() {
    }

    public Employee(String imię, String nazwisko, String pesel, String dział, int pensja) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.dział = dział;
        this.pensja = pensja;
    }

    public String getDział() {
        return dział;
    }

    public int getPensja() {
        return pensja;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "imię='" + imię + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dział='" + dział + '\'' +
                ", pensja=" + pensja +
                '}';
    }
}
