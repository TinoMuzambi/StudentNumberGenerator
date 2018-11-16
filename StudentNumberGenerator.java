import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Tino Muzambi
 * @version 29 Oct 2018 21:25
 */

public class StudentNumberGenerator {

    private static String name;
    private static String surname;
    private static String studentNumber;
    private static ArrayList<String> studentNumbers=new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            Scanner input=new Scanner(System.in);
            System.out.println("0. quit");
            System.out.println("1. ObtainStudentNumber");
            System.out.println("2. ObtainStudentNumbers");
            int ans=input.nextInt();
            if (ans==0) {break;}

            switch (ans) {
                case 0:
                    break;
                case 1:
                    System.out.println("Enter name");
                    name=input.next();
                    System.out.println("Enter surname");
                    surname=input.next();
                    studentNumber=ObtainStudentNumber(name, surname);
                    studentNumbers.add(studentNumber);
                    System.out.println(studentNumber);
                    break;
                case 2:
                    System.out.println(studentNumbers);
                    break;
            }
        }
    }

    /**
     * Returns a student number from
     * the given name and surname.
     */
    private static String ObtainStudentNumber(String name, String surname) {
        name=name.toUpperCase();
        surname=surname.toUpperCase();
        surname=surname.replace("A","");
        surname=surname.replace("E","");
        surname=surname.replace("I","");
        surname=surname.replace("O","");
        surname=surname.replace("U","");
        if (surname.length()>3) {
            surname = surname.substring(0, 3);
        }
        else {
            while (surname.length()!=3) {
                surname=surname+"X";
            }
        }
        if (name.length()>3) {
            name = name.substring(0, 3);
        }
        else {
            while (name.length()!=3) {
                name=name+"X";
            }
        }
        int count=1;
        String sNumber=surname+name+String.format("%03d",count);
        while (studentNumbers.contains(sNumber)) {
            count++;
            sNumber=surname+name+String.format("%03d",count);
        }
        return sNumber;
    }
}
