package com.example.models;

import java.util.Date;

public class Music {
  private String name;
  private String artist;
  private Date releaseDate;

  public Music() {}

  public Music(String name) {
    this.name = name;
    this.artist = "unknown";
    this.releaseDate = new Date();
  }

  public Music(String name, String artist) {
    this.name = name;
    this.artist = artist;
    this.releaseDate = new Date();
  }

  public Music(String name, String artist, Date releaseDate) {
    this.name = name;
    this.artist = artist;
    this.releaseDate = releaseDate;
  }

  public String getName() {
    return this.name;
  }

  public String getArtist() {
    return this.artist;
  }

  public Date getReleaseDate() {
    return this.releaseDate;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public void setReleaseDate(Date releaseDate) {
    this.releaseDate = releaseDate;
  }

  @Override
  public String toString() {
    return String.format("%s - %s - %s", this.name, this.artist, this.releaseDate.toString());
  }
}
