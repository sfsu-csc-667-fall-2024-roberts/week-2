package students.writers;

import java.io.IOException;

import students.Student;

public abstract class StudentWriter {
    protected Student student;

    public StudentWriter(Student student) {
        this.student = student;
    }

    public abstract void write() throws IOException;
}
