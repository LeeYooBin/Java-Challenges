package com.example.models;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
  private String name;
  private Set<Course> enrolledCourses = new LinkedHashSet<>();
  private Set<Mentoring> enrolledMentorings = new LinkedHashSet<>();
  private Set<Course> completedCourses = new LinkedHashSet<>();
  private Set<Mentoring> completedMentorings = new LinkedHashSet<>();

  public Dev(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Course> getEnrolledCourses() {
    return enrolledCourses;
  }

  public void enrollInCourse(Course course) {
    enrolledCourses.add(course);
  }

  public Set<Mentoring> getEnrolledMentorings() {
    return enrolledMentorings;
  }

  public void enrollInMentoring(Mentoring mentoring) {
    enrolledMentorings.add(mentoring);
  }

  public void completeCourse(Course course) {
    if (enrolledCourses.contains(course)) {
      enrolledCourses.remove(course);
      completedCourses.add(course);
    } 
    else {
      System.out.println(String.format("Curso não está matriculado: %s", course.getTitle()));
    }
  }

  public void completeMentoring(Mentoring mentoring) {
    if (enrolledMentorings.contains(mentoring)) {
      enrolledMentorings.remove(mentoring);
      completedMentorings.add(mentoring);
    } 
    else {
      System.out.println(String.format("Mentoria não está matriculada: %s", mentoring.getTitle()));
    }
  }

  @Override
  public String toString() {
    return String.format("Dev{nome='%s', cursos matriculados=%s, mentorias matriculadas=%s, cursos completados=%s, mentorias completadas=%s}", 
                          name, enrolledCourses, enrolledMentorings, completedCourses, completedMentorings);
  }
}
