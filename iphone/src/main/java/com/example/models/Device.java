package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Device {
  private List<Contact> contactList;
  private List<Message> messageList;
  private String version;
  private Boolean internetConnection;

  public Device() {
    this.contactList = new ArrayList<Contact>();
    this.messageList = new ArrayList<Message>();
    this.version = "1.0.0";
    this.internetConnection = false;
  }

  public List<Contact> getContactList() {
    return contactList;
  }

  public void setContactList(List<Contact> contactList) {
    this.contactList = contactList;
  }

  public List<Message> getMessageList() {
    return messageList;
  }

  public void setMessageList(List<Message> messageList) {
    this.messageList = messageList;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public Boolean getInternetConnection() {
    return internetConnection;
  }

  public void setInternetConnection(Boolean internetConnection) {
    this.internetConnection = internetConnection;
  }

  public void turnOn() {
    System.out.println("Aparelho ligado.");
  }

  public void turnOff() {
    System.out.println("Aparelho desligado.");
  }

  public void call(Contact contact) {
    System.out.printf("Ligando para %s.\n", contact.getName());
  }

  public void answerCall() {
    System.out.println("Ligação atendida.");
  }

  public void startVoiceMail() {
    System.out.println("Escutando correio de voz.");
  }

  public void sendMessage(Contact contact, String message) {
    System.out.printf("Mensagem de texto: %s\n\n Enviada para %s.\n", message, contact.getName());
  }

  public void readMessage(String message) {
    System.out.println(message);
  }

  public void connectToInternet() {
    this.internetConnection = true;
    System.out.println("Conectado à internet.");
  }

  public void disconnectToInternet() {
    this.internetConnection = false;
    System.out.println("Sem internet.");
  }
}
