package students.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
                String.format("# %s, %s %s\n\n",
                        this.student.getLastName(),
                        this.student.getFirstName(),
                        this.student.getMiddleName().trim().length() == 0 ? "" : this.student.getMiddleName().charAt(0))
                        .trim());
        this.writer.write(String.format("Major: %s\n", this.student.getMajor()));
        this.writer.write(String.format("Overall GPA: %f\n\n", this.student.getGPA()));

        this.writer.write("| Year | Semester | course | grade |\n" +
                "|——————|—————————-|————————|—————-—|\n");

        /**
         * | Year | Semester | course | grade |
         * |——————|—————————-|————————|—————-—|
         * | 2000 | spring | csc220 | A |
         * | 2000 | spring | math256| A |
         * 
         * 
         */
    }

}
