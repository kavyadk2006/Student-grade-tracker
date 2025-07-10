import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades;

    Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int grade : grades) {
            if (grade > max) max = grade;
        }
        return max;
    }

    int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int grade : grades) {
            if (grade < min) min = grade;
        }
        return min;
    }
}

 class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < studentCount; i++) {
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades for " + name + ": ");
            int gradeCount = scanner.nextInt();

            System.out.println("Enter grades:");
            for (int j = 0; j < gradeCount; j++) {
                System.out.print("Grade " + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.grades.add(grade);
            }
            scanner.nextLine(); // consume newline
            students.add(student);
        }

        // Display Summary Report
        System.out.println("\n----- Student Grade Summary -----");
        for (Student student : students) {
            System.out.println("Name: " + student.name);
            System.out.println("Grades: " + student.grades);
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.println("Highest: " + student.getHighest());
            System.out.println("Lowest: " + student.getLowest());
            System.out.println("----------------------------------");
        }

        scanner.close();
    }
}
