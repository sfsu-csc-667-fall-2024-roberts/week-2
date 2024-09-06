package students.readers;

import java.io.IOException;

import students.Student;

public abstract class FileReader {
    public abstract Student read() throws IOException;
}
