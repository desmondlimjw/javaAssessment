package com.generation.java;

import com.generation.model.Course;
import com.generation.model.Student;
import com.generation.service.CourseService;
import com.generation.service.StudentService;
import com.generation.utils.PrinterHelper;

import java.text.ParseException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args )
            throws ParseException
    {

        //create new instance of studentService and courseService
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        //get user input
        Scanner scanner = new Scanner( System.in );
        int option;
        do
        {
            //call showMainMenu method to display menu. Update the option variable with user input
            PrinterHelper.showMainMenu();
            option = scanner.nextInt();
            switch ( option )
            {
                //calls the register student method, with studentService object and scanner input as arguments
                case 1:
                    registerStudent( studentService, scanner );
                    break;
                case 2:
                    findStudent( studentService, scanner );
                    break;
                case 3:
                    gradeStudent( studentService, scanner );
                    break;
                case 4:
                    enrollCourse( studentService, courseService, scanner );
                    break;
                case 5:
                    showStudentsSummary( studentService, scanner );
                    break;
                case 6:
                    showCoursesSummary( courseService, scanner );
                    break;
                case 7:
                    showPassedCourses( studentService, scanner );
                    break;
            }
        }
        while ( option != 8 );
    }

    //Option 1: register student
    private static void registerStudent( StudentService studentService, Scanner scanner ) throws ParseException {
        Student student = PrinterHelper.createStudentMenu( scanner );
        studentService.subscribeStudent( student );
    }


    private static Student getStudentInformation( StudentService studentService, Scanner scanner )
    {
        //when this method is called, programme will prompt user for ID and store it in studentID String
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        //create a student object and assign it the output of findStudent method
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        return student;
    }

    private static void findStudent( StudentService studentService, Scanner scanner )
    {
        //when user selects option 2, findStudent method is called.
        //1. Creates a student object and assigns it the output of getStudentInformation method
        Student student = getStudentInformation( studentService, scanner );
        if ( student != null )
        {
            System.out.println( "Student Found: " );
            System.out.println( student );
        } else
        {
            System.out.println("No student found.");
        }
    }


    //Option 4: declare enrollCourse method which takes in 3 values
    private static void enrollCourse( StudentService studentService, CourseService courseService,
                                               Scanner scanner )
    {
        System.out.println( "Insert student ID" );
        String studentId = scanner.next();
        //use the findStudent method from the studentService class to assign a value to the student variable
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Invalid Student ID" );
            return;
        }
        System.out.println( student );
        System.out.println( "Insert course ID" );
        String courseId = scanner.next();
        Course course = courseService.getCourse( courseId );
        if ( course == null )
        {
            System.out.println( "Invalid Course ID" );
            return;
        }
        System.out.println( course );
        studentService.enrollToCourse( studentId, course );
        System.out.println( "Student with ID: " + studentId + " enrolled successfully to " + courseId );

    }

    private static void showCoursesSummary( CourseService courseService, Scanner scanner )
    {
        courseService.showSummary();
    }

    //Option 5
    private static void showStudentsSummary( StudentService studentService, Scanner scanner )
    {
        if (!studentService.showSummary())
        {
            System.out.println("No Student Yet");
        }
    }

    private static void gradeStudent( StudentService studentService, Scanner scanner )
    {
        //Get Student object from the input and print out all the enrolled courses
        Student student = getStudentInformation( studentService, scanner );
        System.out.println( "Enrolled course:" );

        //TODO - 1. Use forEach to display values of getEnrolledCourses HashMap
        for(Course course : student.getEnrolledCourses()) {
            System.out.println(course.toString());
        }

        //TODO - 2. Prompt user for courseId and store it in a string
        System.out.println( "Insert courseID to be graded:" );
        String courseId = scanner.next();
        Course course = student.findCourseById(courseId);
        if(course == null)
        {
            System.out.println("The student is not enrolled to a course with ID: " + courseId);
        }
        else {
            System.out.println("Insert course grade for: ");
            float courseGrade = scanner.nextFloat();
            student.setGrade(course.getCode(), courseGrade);
            System.out.println("Successfully graded.");
        }
    }

    private static void showPassedCourses(StudentService studentService, Scanner scanner )
    {
        System.out.println( "Enter student ID: " );
        String studentId = scanner.next();
        Student student = studentService.findStudent( studentId );
        if ( student == null )
        {
            System.out.println( "Student not found" );
        }
        else
        {
            if (student.findPassedCourses().size() == 0)
            {
                System.out.println( "No passed courses available" );
            }
           else
            {
                System.out.println(student.findPassedCourses());
            }
        }
    }
}
