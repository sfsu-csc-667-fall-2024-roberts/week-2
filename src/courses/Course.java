package courses;

public class Course implements Comparable<Course> {
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

    @Override
    public int compareTo(Course compareCourse) {
        if (this.year == compareCourse.year && this.semester.equals(compareCourse.semester)
                && this.name.equals(compareCourse.name)) {
            return 0;
        }

        // sort by year
        if (this.year < compareCourse.year) {
            return -1;
        } else if (this.year > compareCourse.year) {
            return 1;
        }

        // then by semester
        if (this.semester.equals("Spring") && compareCourse.semester.equals("Fall")) {
            return -1;
        } else if (this.semester.equals("Fall") && compareCourse.semester.equals("Spring")) {
            return 1;
        }

        // then by name
        return this.name.compareTo(compareCourse.name);
    }

}
