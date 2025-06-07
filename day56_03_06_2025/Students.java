/*

Design and implement a Java application to manage a list of students 
along with their subject-wise marks and determine the student who 
has scored the highest total marks.

Your task is to implement getTopper() method only.

Sample Ouput:
----------------
Topper is: Alice (Roll: 101) with total marks: 185
*/

import java.util.*;

public class Students {
    List<Student> students;

    public Students() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void readStudentData() {
        // Sample student data setup
        Student s1 = new Student("Alice", 101, Arrays.asList(
                new Marks("Math", 90),
                new Marks("Science", 95)
        ));

        Student s2 = new Student("Bob", 102, Arrays.asList(
                new Marks("Math", 80),
                new Marks("Science", 85)
        ));

        Student s3 = new Student("Charlie", 103, Arrays.asList(
                new Marks("Math", 88),
                new Marks("Science", 92)
        ));

        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public static class Student {
        String name;
        int rollNumber;
        List<Marks> marks;

        public Student(String name, int rollNumber, List<Marks> marks) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.marks = marks;
        }

        public String toString() {
            return name + " (Roll: " + rollNumber + ")";
        }
    }

    public static class Marks {
        String subject;
        int marks;

        public Marks(String subject, int marks) {
            this.subject = subject;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Students students = new Students();
        students.readStudentData(); // assume students are populated here

        Student topper = getTopper(students);
        int totalMarks = 0;
        for (Marks m : topper.marks) {
            totalMarks += m.marks;
        }
        System.out.println("Topper is: " + topper + " with total marks: " + totalMarks);
    }

    static Student getTopper(Students students2) {
        // Implement only this method. Do not alter the code.
        Student s1=new Student("",0,Arrays.asList(new Marks("",0)));
        int max=0;
        for(Student s:students2.students){
            int sum=0;
            for(Marks i:s.marks){
                sum+=i.marks;
            }
            if(sum>max){
                max=sum;
                s1=new Student(s.name,s.rollNumber,s.marks);
            }
        }
        
        return s1;
    }
}
