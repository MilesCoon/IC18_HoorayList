import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Can't use primitive data types in ArrayList:
        // int, double, char, boolean
        // Can use reference data types:
        // String, Contact, Double, Integer
        HoorayList<String> students = new HoorayList<>();
        students.add("Hunter");
        students.add("Miles");
        students.add("Sydney");
        students.add("Alex");
        students.add("Atharva");

        students.add(0, "Mike");

        System.out.println(students);

        students.remove(1);

        System.out.println(students);

        students.remove("Miles");

        System.out.println(students);
    }
}