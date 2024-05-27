package com.example.models;

public class Iphone {
  private Device device;
  private MusicPlayer musicPlayer;
  private InternetBrowser browser;

  public Iphone() {
  }

  public Device getDevice() {
    return device;
  }

  public void setDevice(Device device) {
    this.device = device;
  }

  public MusicPlayer getMusicPlayer() {
    return musicPlayer;
  }

  public void setMusicPlayer(MusicPlayer musicPlayer) {
    this.musicPlayer = musicPlayer;
  }

  public InternetBrowser getBrowser() {
    return browser;
  }

  public void setBrowser(InternetBrowser browser) {
    this.browser = browser;
  }
}
