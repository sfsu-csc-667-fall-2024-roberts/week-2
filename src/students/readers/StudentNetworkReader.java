package students.readers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import courses.Course;
import students.Student;

public class StudentNetworkReader extends FileReader {

    private BufferedReader reader;

    public StudentNetworkReader(InputStream in) {
        super();

        this.reader = new BufferedReader(new InputStreamReader(in));
    }

    @Override
    public Student read() throws IOException {
        String studentNameLine = reader.readLine();
        reader.readLine();

        List<Course> courses = new ArrayList<>();
        String currentLine;

        while ((currentLine = reader.readLine()) != null) {
            if (currentLine.trim().length() == 0) {
                break;
            }

            courses.add(new Course(currentLine));
        }

        currentLine = reader.readLine().trim();

        Student student = new Student(studentNameLine, currentLine);

        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            student.addCourse(iterator.next());
        }

        return student;
    }

}
