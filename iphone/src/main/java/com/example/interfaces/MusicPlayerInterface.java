package com.example.interfaces;

import java.util.List;

import com.example.models.Music;

public interface MusicPlayerInterface {
  List<Music> listMusicList();
  void play();
  void pause();
  void selectMusic(Music music);
}