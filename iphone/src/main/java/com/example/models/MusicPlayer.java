package com.example.models;

import java.util.ArrayList;
import java.util.List;

import com.example.interfaces.MusicPlayerInterface;

public class MusicPlayer implements MusicPlayerInterface {
  private String name;
  private String version;
  private List<Music> musicList;
  private Music currentSelectedMusic;

  public MusicPlayer() {
  }

  public MusicPlayer(String name, String version) {
    this.name = name;
    this.version = version;
    this.musicList = new ArrayList<Music>();
    this.currentSelectedMusic = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public List<Music> getMusicList() {
    return musicList;
  }

  public void setMusicList(List<Music> musicList) {
    this.musicList = musicList;
  }

  public Music getCurrentSelectedMusic() {
    return currentSelectedMusic;
  }

  public void setCurrentSelectedMusic(Music currentSelectedMusic) {
    this.currentSelectedMusic = currentSelectedMusic;
  }

  public List<Music> listMusicList() {
    return this.musicList;
  }

  public void selectMusic(Music music) {
    System.out.printf("Música %s selecionada com sucesso.\n", music.getName());
  }

  public void play() {
    System.out.printf("Tocando %s.\n", this.currentSelectedMusic);
  }

  public void pause() {
    System.out.println("Reprodutor pausado.");
  }
}
