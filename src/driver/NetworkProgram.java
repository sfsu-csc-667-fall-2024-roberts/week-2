package driver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import students.Student;
import students.readers.StudentNetworkReader;
import students.writers.MarkdownNetworkStudentWriter;

public class NetworkProgram {
    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(9876)) {
            Socket socket = server.accept();

            StudentNetworkReader reader = new StudentNetworkReader(socket.getInputStream());
            Student student = reader.read();

            MarkdownNetworkStudentWriter writer = new MarkdownNetworkStudentWriter(student, socket.getOutputStream());
            writer.write();

            socket.close();
        }
    }
}
