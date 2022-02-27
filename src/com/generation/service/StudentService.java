package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;

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
        return students.get(studentId);
    }

    public boolean showSummary()
    {
        //TODO: use nested for loop to 1) display each Student object (DONE) + 2) use getEnrolledCourses to extract
        // enrolled courses (To use if statement to check, otherwise print enrolled course using forEach loop) (DONE)
        if(students.size() == 0) // check if arrayList is empty. return false if it is empty.
        {
            return false;
        }
        for (Student student : students.values()) //outer loop: forEach to print values (Student object) from students
            // HashMap
            {
                System.out.println(student);

            if(student.getEnrolledCourses().size() == 0) { //Check if student is enrolled in any course. Only execute
                // the inner loop for those with enrolled courses (continue keyword)
                continue;
            }
                System.out.println("Enrolled course(s): ");
                for (Course course : student.getEnrolledCourses().values()) //inner loop: print values (Course object) from
                // enrolledCourses HashMap
                {
                    System.out.println(course);
                }
            }
        return true;
    }

    public void enrollToCourse( String studentId, Course course )
    {
        //TODO - enroll student to the course with the studentId and course passed in as the parameters (DONE)
        findStudent(studentId).enrollToCourse(course);
    }


}
