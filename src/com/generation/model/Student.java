package com.generation.model;

import java.util.*;

public class Student
    extends Person
    implements Evaluation
{
    //field
    float PASS_MIN_GRADE = 3.0f;
    private final Map<String, EnrolledCourse> enrolledCourses = new HashMap<>(); //create HashMap to hold enrolledCourses
//    private final HashMap<String, Float> gradedCourses = new HashMap<>(); //HashMap to store course and student grade

    //constructor
    public Student( String id, String name, String email, Date birthDate )
    {
        //inherit fields from parent Person class
        super( id, name, email, birthDate );
    }

    public void enrollToCourse( Course course )
    {
        //TODO - Add the course to the enrolledCourses HashMap. Key = Course code, Value = Course object. Done.
        //check if the course is already enrolled by the student (111)
        if ( !enrolledCourses.containsKey( course.getCode() ) ) {
            //Need to create a new instance of enrolled course, pass the course object
            // in and store in the enrolledCourses HashMap
            EnrolledCourse enrolledCourse = new EnrolledCourse(course);
            enrolledCourses.put(course.getCode(), enrolledCourse);

            //e.g. student 111 have a hashmap of 2 enrolled courses
            // {"course id 1", "course name", "course code"} + grade
            // {"course id 2", "course name", "course code"} + grade
        } else {
            System.out.println("Course already exists in student's enrolled courses");
        }
    }

    @Override
    public List<Course> findPassedCourses()
    {
        //Get user to select an enrolled course to be graded (111)
        //course object (001), grade (4) - added to the passedCourse ArrayList
        //course object (002), grade (0)

        List<Course> passedCourses = new ArrayList<>();

        for ( EnrolledCourse enrolledCourse : enrolledCourses.values() )
        {
            if ( enrolledCourse.getGrade() >= PASS_MIN_GRADE )
            {
                passedCourses.add( enrolledCourse );
            }
        }
        return passedCourses;
    }

    public Course findCourseById( String courseId )
    {
        //TODO - Done.
       return enrolledCourses.getOrDefault(courseId, null);
    }

    @Override
    public List<Course> getEnrolledCourses()
    {
        //TODO - Done.
        return new ArrayList<>(enrolledCourses.values());
    }

    //TODO - Create method to insert course code and grade into the gradedCourses HashMap - Done.
    public void setGrade (String courseCode, float grade) {
        if (enrolledCourses.containsKey(courseCode))
        {
            enrolledCourses.get(courseCode).setGrade(grade);
        }
    }

    public float getGrade(String courseCode)
    {
        float grade = 0;
        if ( enrolledCourses.containsKey( courseCode ) )
        {
            grade = enrolledCourses.get( courseCode ).getGrade();
        }
        return grade;
    }

    @Override
    public String toString()
    {
        return "Student {" + super.toString() + "}";
    }

}
