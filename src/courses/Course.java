package courses;

public class Course {
    private int year;
    private String semester;
    private String name;
    private String grade;

    public Course(String rawCourse) {
        String[] courseParts = rawCourse.split("-|:");

        this.year = Integer.parseInt(courseParts[0]);
        this.semester = courseParts[1];
        this.name = courseParts[2];
        this.grade = courseParts[3].trim();
    }

    public int getYear() {
        return year;
    }

    public String getSemester() {
        return semester;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

}
