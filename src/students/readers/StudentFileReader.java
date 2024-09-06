package students.readers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import courses.Course;
import students.Student;

public class StudentFileReader extends FileReader {
    private List<String> lines;

    public StudentFileReader(String fileName) {
        try {
            this.lines = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            this.lines = new ArrayList<>();
        }
    }

    @Override
    public Student read() {
        Student student = new Student(this.lines.get(0), this.lines.get(this.lines.size() - 1));

        // starting from line 2, create courses until I see an empty line
        this.lines.remove(0);
        this.lines.remove(0);
        this.lines.remove(this.lines.size() - 1);

        Iterator<String> iterator = this.lines.iterator();

        while (iterator.hasNext()) {
            String line = iterator.next();

            if (line.trim().length() == 0) {
                break;
            } else {
                student.addCourse(new Course(line));
            }
        }

        return student;
    }
}
