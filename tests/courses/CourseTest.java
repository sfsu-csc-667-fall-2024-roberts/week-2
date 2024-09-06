package tests.courses;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import courses.Course;

public class CourseTest {

    @Test
    public void testCourseParsing() {
        Course course = new Course("2024-fall-csc667: A");

        assertEquals(2024, course.getYear());
        assertEquals("fall", course.getSemester());
        assertEquals("csc667", course.getName());
        assertEquals("A", course.getGrade());
    }
}
