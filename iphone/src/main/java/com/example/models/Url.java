package com.example.models;

public class Url {
  private String address;

  public Url() {}

  public Url(String address) {
    this.address = address;
  }

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return this.address;
  }
}
