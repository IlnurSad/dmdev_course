package week5.homework1.task1;

import java.util.List;

public class Student implements Comparable<Student>{
    private String firstName;
    private String lastName;
    private int courseNumber;
    private List<Integer> gradesForStudies;

    public Student(String firstName, String lastName, int courseNumber, List<Integer> gradesForStudies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseNumber = courseNumber;
        this.gradesForStudies = gradesForStudies;
    }

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public List<Integer> getGradesForStudies() {
        return gradesForStudies;
    }

    public void setGradesForStudies(List<Integer> gradesForStudies) {
        this.gradesForStudies = gradesForStudies;
    }

    @Override
    public String toString() {
        if (courseNumber == 0 && gradesForStudies == null) {
            return "Student{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courseNumber=" + courseNumber +
                ", gradesForStudies=" + gradesForStudies +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return firstName.compareTo(o.getFirstName()) == 0 ? lastName.compareTo(o.getLastName()) : firstName.compareTo(o.getFirstName());
    }
}
