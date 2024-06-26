package com.example.models;

public class Course {
  private String title;
  private String description;
  private int workload;

  public Course(String title, String description, int workload) {
    this.title = title;
    this.description = description;
    this.workload = workload;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getWorkload() {
    return workload;
  }

  public void setWorkload(int workload) {
    this.workload = workload;
  }

  @Override
  public String toString() {
    return String.format("Curso{título='%s', descrição='%s', carga horária=%d}", title, description, workload);
  }
}
