package com.example.ziragraphql.entity;

public class User extends BaseEntity {
  private String workUserId;
  private String name;
  private String mail;
  private String password;

  public User() {
    super();
  }

  public User(String id, String workUserId, String name, String mail, String password) {
    super(id);
    this.workUserId = workUserId;
    this.name = name;
    this.mail = mail;
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getWorkUserId() {
    return workUserId;
  }

  public void setWorkUserId(String workUserId) {
    this.workUserId = workUserId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  @Override
  public String toString() {
    return "User{" +
            "id='" + id + '\'' +
            ", workUserId='" + workUserId + '\'' +
            ", name='" + name + '\'' +
            ", mail='" + mail + '\'' +
            '}';
  }
}

