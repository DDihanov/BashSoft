package main.bg.softuni.repository;

import main.bg.softuni.dataStructures.SimpleSortedList;
import main.bg.softuni.models.Course;
import main.bg.softuni.models.Student;

import java.util.Comparator;

public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);

    SimpleSortedList<Course> getAllCoursesSorted(Comparator<Course> cmp);

    SimpleSortedList<Student> getAllStudentsSorted(Comparator<Student> cmp);
}
