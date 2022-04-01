package com.generation.model;

public class EnrolledCourse extends Course {
//contain all the enrolled course(s) from the respective student(s), as well as the grade of each enrolled course(s)
    private float grade = 0;

    public EnrolledCourse(Course course) {
        ///inherit methods from parent class
        super(course.getCode(), course.getName(), course.getCredits(), course.getModule());
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }
}
