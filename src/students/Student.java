package students;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import courses.Course;

public class Student {
    private String firstName;
    private String lastName;
    private String middleName;
    private String major;
    private List<Course> courses;

    private static Map<String, Float> grades;
    static {
        grades = new HashMap<>();

        grades.put("A", 4.0f);
        grades.put("B", 3.0f);
        grades.put("C", 2.0f);
        grades.put("D", 1.0f);
    }

    public Student(String name, String major) {
        String[] nameParts = name.split("\s+");
        this.firstName = nameParts[0];

        if (nameParts.length == 2) {
            this.middleName = "";
        } else {
            this.middleName = nameParts[1];
        }

        this.lastName = nameParts[nameParts.length - 1];
        this.major = major;

        this.courses = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getMajor() {
        return major;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public float getGPA() {
        if (this.courses.size() == 0) {
            return 0;
        }

        float gpa = 0;

        for (Course course : courses) {
            gpa += Student.grades.get(course.getGrade());
        }

        return gpa / this.courses.size();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
