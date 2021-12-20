package lesson9;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class HomeWork9 {

    public static void main(String[] args) {

    }

    List<Course> uniqCourse (List<Student> students) {
        return students.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    Map<String,Long> mostStudets (List<Student> students) {
        return students.stream()
                .collect(
                        Collectors.groupingBy(Student::getName,Collectors.counting())
                );
    }

    List<Student> students (List<Student> listStudents, Course course) {
        return listStudents.stream()
                .filter(listStudent -> listStudent.getAllCourses().equals(course))
                .collect(Collectors.toList());
    }


    interface Student {
        String getName();
        List<Course> getAllCourses();
    }
    interface Course {}



}
