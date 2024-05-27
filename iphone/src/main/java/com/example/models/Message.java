package com.example.models;

public class Message {
  private String text;
  private String number;

  public Message(){}

  public Message(String text, String number){
    this.text = text;
    this.number = number;
  }

  public String getText() {
    return this.text;
  }

  public String getNumber() {
    return this.number;
  }

  public void setText(String text) {
    this.text = text;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return String.format("$s\n\n%s", this.number, this.text);
  }
}
