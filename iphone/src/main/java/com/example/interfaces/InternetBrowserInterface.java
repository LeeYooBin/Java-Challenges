package com.example.interfaces;

import com.example.models.Url;

public interface InternetBrowserInterface {
  void showPageUrl(Url url);
  void addNewTab();
  void refreshPage();
  void navigateTo(Url url);
  void returnPage();
  void advance();
  void stopLoading();
  void addToFavorites(Url url);
  void openPrivateMode();
  void closePrivateMode();
  void showHistoric();
  void cleanHistoric();
  void showFavorites();
}
