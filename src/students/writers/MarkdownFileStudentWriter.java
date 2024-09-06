package students.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import courses.Course;
import students.Student;

public class MarkdownFileStudentWriter extends StudentWriter {

    private BufferedWriter writer;

    public MarkdownFileStudentWriter(Student student, String fileName) throws IOException {
        super(student);

        this.writer = new BufferedWriter(new FileWriter(fileName));
    }

    @Override
    public void write() throws IOException {

        this.writer.write(
                String.format("# %s, %s %s  \n\n",
                        this.student.getLastName(),
                        this.student.getFirstName(),
                        this.formatMiddleName()));
        this.writer.write(String.format("Major: %s  \n", this.student.getMajor()));
        this.writer.write(String.format("Overall GPA: %f  \n\n", this.student.getGPA()));

        this.writer.write("| Year | Semester | Course | Grade |\n" +
                "|——————|—————————-|————————|—————-—|\n");

        List<Course> courses = this.student.getCourses();
        Collections.sort(courses);

        Iterator<Course> iterator = courses.iterator();

        while (iterator.hasNext()) {
            Course current = iterator.next();

            this.writer.write(
                    String.format("| %d | %s | %s | %s |\n", current.getYear(), current.getSemester(),
                            current.getName(),
                            current.getGrade()));
        }

        this.writer.flush();
        this.writer.close();
    }

    private String formatMiddleName() {
        if (this.student.getMiddleName() == null || this.student.getMiddleName().trim().length() == 0) {
            return "";
        } else {
            return this.student.getMiddleName().charAt(0) + "";
        }
    }

}
