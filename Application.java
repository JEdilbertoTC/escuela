package  learning.java.school;

import java.util.Scanner;

public class Application{
    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("Edilberto", "1"),
                new Student("Alain", "2"),
                new Student("Isaias", "3"),
                new Student("Edgar", "4")
        };
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < students.length; i++) {
            System.out.println("Name: " + students[i].getName() + " code: " + students[i].getCode());
            System.out.print("Asistio: ");
            String response = scanner.next();
            // System.out.println(students[i].getName() + (response.equalsIgnoreCase("Y")));
            if (response.equalsIgnoreCase("Y")) {
                System.out.println("SI");
            } else if (response.equalsIgnoreCase("N")) {
                System.out.println("NO");
            } else {
                System.out.println("Incorrecto");
                i--;
            }
        }
    }
}
