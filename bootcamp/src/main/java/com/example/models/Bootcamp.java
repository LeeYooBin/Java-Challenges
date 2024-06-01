package com.example.models;

import java.util.HashSet;
import java.util.Set;

public class Bootcamp {
  private String name;
  private String description;
  private Set<Course> courses = new HashSet<>();
  private Set<Mentoring> mentorings = new HashSet<>();

  public Bootcamp(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Set<Course> getCourses() {
    return courses;
  }

  public void addCourse(Course course) {
    courses.add(course);
  }

  public Set<Mentoring> getMentorings() {
    return mentorings;
  }

  public void addMentoring(Mentoring mentoring) {
    mentorings.add(mentoring);
  }

  @Override
  public String toString() {
    return String.format("Bootcamp{nome='%s', descrição='%s', cursos=%s, mentorias=%s}", 
                          name, description, courses, mentorings);
  }
}
