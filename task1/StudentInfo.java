package week5.homework1.task1;

import java.util.List;

public class StudentInfo {
    private List<Student> students;
    private Double averageGrades;

    public StudentInfo(List<Student> students, Double averageGrades) {
        this.students = students;
        this.averageGrades = averageGrades;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Double getAverageGrades() {
        return averageGrades;
    }

    public void setAverageGrades(Double averageGrades) {
        this.averageGrades = averageGrades;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "students=" + students +
                ", averageGrades=" + averageGrades +
                '}';
    }
}
