package com.example.models;

import java.util.ArrayList;
import java.util.List;

import com.example.interfaces.InternetBrowserInterface;

public class InternetBrowser implements InternetBrowserInterface {
  private String name;
  private String version;
  private Url currentUrl;
  private List<Url> historic;
  private List<Url> favorites;
  private Boolean privateMode;

  public InternetBrowser() {
  }

  public InternetBrowser(String name, String version) {
    this.name = name;
    this.version = version;
    this.currentUrl = null;
    this.historic = new ArrayList<Url>();
    this.favorites = new ArrayList<Url>();
    this.privateMode = false;
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

  public Url getCurrentUrl() {
    return currentUrl;
  }

  public void setCurrentUrl(Url currentUrl) {
    this.currentUrl = currentUrl;
  }

  public List<Url> getHistoric() {
    return historic;
  }

  public void setHistoric(List<Url> historic) {
    this.historic = historic;
  }

  public List<Url> getFavorites() {
    return favorites;
  }

  public void setFavorites(List<Url> favorites) {
    this.favorites = favorites;
  }

  public Boolean getPrivateMode() {
    return privateMode;
  }

  public void setPrivateMode(Boolean privateMode) {
    this.privateMode = privateMode;
  }

  public void showPageUrl(Url url) {
    System.out.println(url.getAddress());
  }

  public void addNewTab() {
    System.out.println("Nova aba aberta.");
  }

  public void refreshPage() {
    System.out.println("Página atualizada.");
  }

  public void navigateTo(Url url) {
    this.currentUrl = url;
    this.historic.add(url);
    System.out.println(url.getAddress());
  }

  public void returnPage() {
    this.historic.removeLast();
    System.out.println("Página anterior.");
  }

  public void advance() {
    System.out.println("Próxima página.");
  }

  public void stopLoading() {
    System.out.println("Parou de carregar.");
  }

  public void addToFavorites(Url url) {
    this.favorites.add(url);
    System.out.println("Adicionado aos favoritos.");
  }

  public void openPrivateMode() {
    this.privateMode = true;
    System.out.println("Modo privado aberto.");
  }

  public void closePrivateMode() {
    this.privateMode = false;
    System.out.println("Modo privado fechado.");
  }
  
  public void showHistoric() {
    for (Url url : this.historic) System.out.println(url);
  }

  public void cleanHistoric() {
    this.historic = new ArrayList<Url>();
  }

  public void showFavorites() {
    for (Url url : this.favorites) System.out.println(url);
  }
}
