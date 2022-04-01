package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.model.EnrolledCourse;

import java.util.*;

public class StudentService
{
    private final Map<String, Student> students = new HashMap<>();

    //create some dummy students
    public void registerStudent( Student student ) {
        students.put( student.getId(), student );
    }

    //create constructor to add some students
    public StudentService() {
        Date date1 = new Date(109, 5, 23);
        Date date2 = new Date(108, 4, 22);
        Date date3 = new Date(107, 3, 21);
        registerStudent(new Student("S123", "Desmond Lim", "des@gmail.com", date1));
        registerStudent(new Student("S234", "Diana Lee", "dia@gmail.com", date2));
        registerStudent(new Student("S456", "Dylan Leow", "dyl@gmail.com", date3));
    }

    public void subscribeStudent( Student student )
    {
        students.put( student.getId(), student );
    }

    public Student findStudent( String studentId )
    {
        //TODO - return studentId (DONE)
       if (students.containsKey(studentId)) {
           return students.get(studentId);
       }
       return null;
    }

    public boolean showSummary()
    {
        if (students.size() != 0) {
            for (Student student : students.values()) {
                System.out.println(student);

                //Show courses enrolled per student
                System.out.println( "Enrolled Courses: " );
                List<Course> course = student.getEnrolledCourses();
                if (course.size() != 0) {
                    for (Course mycourse : course) {
                        System.out.println(mycourse + " Grade: " + student.getGrade(mycourse.getCode()));
                    }
                }
                else {
                    System.out.println("No course enrolled for this student");
                }
            }
            return true;
        }
        return false;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        if ( students.containsKey( studentId ) )
        {
            //Get the student object based on the studentId - 111
            Student student =  students.get( studentId );
            //enrollToCourse is a method in the student Class, pass in the course
            // object for enrollment
            student.enrollToCourse(course);
        }
    }

}
