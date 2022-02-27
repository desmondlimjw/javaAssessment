package com.generation.model;

import java.util.*;


public class Student
    extends Person
    implements Evaluation
{
    //field
    float PASS_MIN_GRADE = 3.0f;
    private final HashMap<String, Course> enrolledCourses = new HashMap<>(); //create HashMap to hold enrolledCourses
    private final HashMap<String, Float> gradedCourses = new HashMap<>(); //HashMap to store course and student grade

    //constructor
    public Student( String id, String name, String email, Date birthDate )
    {
        //inherit fields from parent Person class
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO - Add the course to the enrolledCourses HashMap. Key = Course code, Value = Course object. Done.
        enrolledCourses.put(course.getCode(), course);
    }

    @Override
    public Map<String, Course> findPassedCourses()
    {
        //TODO - Create new HashMap passedCourses. (Not done - TBC)
        // 1. Use forEach to loop through gradedCourses (we want CourseId and grade).
        // 2. If grade >= PASS_MIN_GRADE, put the courseId and grade into passedCourses
        Map<String, Course> passedCourses = new HashMap<>();

//        for (Map.Entry<String, Float> entry : gradedCourses.entrySet())
//            if (grade >= PASS_MIN_GRADE) {
//                passedCourses.put(courseId, enrolledCourses.get(courseId));
//            }
//        return passedCourses;
        return null;
    }

    public Course findCourseById( String courseId )
    {
        //TODO - Done.
       return enrolledCourses.get(courseId);
    }

    @Override
    public Map<String, Course> getEnrolledCourses()
    {
        //TODO - Done.
        return enrolledCourses;
    }

    //TODO - Create method to insert course code and grade into the gradedCourses HashMap - Done.
    public void setGrade (String courseId, float grade) {
        gradedCourses.put(courseId, grade);
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
