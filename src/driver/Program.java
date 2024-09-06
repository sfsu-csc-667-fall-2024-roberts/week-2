package driver;

import java.io.IOException;

import students.Student;
import students.readers.StudentFileReader;
import students.writers.MarkdownFileStudentWriter;

public class Program {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("usage: java driver.Program inputFileName outputFileName");
            System.exit(1);
        }

        // 1st argument input file
        StudentFileReader reader = new StudentFileReader(args[0]);
        Student student = reader.read();

        // 2nd argument md file
        MarkdownFileStudentWriter writer = new MarkdownFileStudentWriter(student, args[1]);
        writer.write();
    }
}
