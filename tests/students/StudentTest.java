package tests.students;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import courses.Course;
import students.Student;

public class StudentTest {
    @Test
    public void testCompleteNameParsing() {
        Student student = new Student("john david roberts", "comp sci");

        assertEquals("john", student.getFirstName());
        assertEquals("david", student.getMiddleName());
        assertEquals("roberts", student.getLastName());
    }

    @Test
    public void testNoMiddleNameParsing() {
        Student student = new Student("john roberts", "comp sci");

        assertEquals("john", student.getFirstName());
        assertEquals("", student.getMiddleName());
        assertEquals("roberts", student.getLastName());
    }

    @Test
    public void testGetGpa() {
        Student student = new Student("j d r", "cs");

        student.addCourse(new Course("1-a-b: A"));
        student.addCourse(new Course("1-a-b: B"));
        student.addCourse(new Course("1-a-b: A"));
        student.addCourse(new Course("1-a-b: C"));

        assertEquals(3.25, student.getGPA(), 0.01);
    }

}
