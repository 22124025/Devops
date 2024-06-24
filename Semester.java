import MCA.Student;
import java.util.Scanner;

public class Semester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter roll number:");
        int rollNumber = scanner.nextInt();
        
        System.out.println("Enter marks for subject 1 out of 100 :");
        int marks1 = scanner.nextInt();
        
        System.out.println("Enter marks for subject 2 out of 100 :");
        int marks2 = scanner.nextInt();
        
        System.out.println("Enter marks for subject 3 out of 100 :");
        int marks3 = scanner.nextInt();
        //----------------------------------
        Student details = new Student(name, rollNumber, marks1, marks2, marks3);

        System.out.println("Student Details:");
        details.display();

        int totalMarks = details.calculateTotalMarks();
        System.out.println("Total Marks: " + totalMarks);

        double percentage = details.calculatePercentage();
        System.out.println("Percentage: " + percentage + "%");
        
        scanner.close();
    }
}
