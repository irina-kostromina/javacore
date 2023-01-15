package streams;

import streams.data.Course;
import streams.data.CourseImpl;
import streams.data.Student;
import streams.data.StudentImpl;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApp {

    public static void main(String[] args) {

        Course course1 = new CourseImpl("History");
        Course course2 = new CourseImpl("Math");
        Course course3 = new CourseImpl("Art");
        Course course4 = new CourseImpl("Physical education");
        Course course5 = new CourseImpl("Native language");
        Course course6 = new CourseImpl("Foreign language");

        Student student1 = new StudentImpl(
                "Ivan", Arrays.asList(course1, course3, course5, course4)
        );
        Student student2 = new StudentImpl(
                "Kate", Arrays.asList(course2, course3, course6)
        );
        Student student3 = new StudentImpl(
                "Alice", Arrays.asList(course1, course3, course4, course6)
        );
        Student student4 = new StudentImpl(
                "Bob", Arrays.asList(course1, course3, course5, course2, course4)
        );

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        Set<String> uniqueCourseNames = getUniqueCourseNames(students);
        System.out.println(uniqueCourseNames);

        List<Student> mindStudents = getMindStudents(students);
        System.out.println("Very mind students");
        showStudents(mindStudents);
        System.out.println("");

        List<Student> courseStudents = getCourseStudents(students, course4);
        System.out.println("Students with course " + course1.getCourseName());
        showStudents(courseStudents);
    }

    private static void showStudents(List<Student> students) {
        for (Student s : students) {
            System.out.println("Name: " + s.getName());
        }
    }

    private static Set<String> getUniqueCourseNames(List<Student> students) {
        return students
                .stream()
                .flatMap(student -> student.getAllCourses().stream())
                .map(course -> course.getCourseName())
                .collect(Collectors.toSet());
    }

    private static List<Student> getMindStudents(List<Student> students) {
        return students
                .stream()
                .sorted(Comparator.comparingInt(student -> ((Student)student).getAllCourses().size()))
                .limit(3)
                .collect(Collectors.toList());
    }

    private static List<Student> getCourseStudents(List<Student> students, Course course) {
        return students
                .stream()
                .filter(student -> student.getAllCourses().contains(course))
                .collect(Collectors.toList());
    }
}

