package com.example.ziragraphql.entity;

public class Auth extends BaseEntity {
  private String projectId;
  private String userId;
  private Role role;

  private enum  Role {
    OWNER,
    MEMBER
  }

  public Auth() {
    super();
  }

  public Auth(String id, String projectId, String userId, Role role) {
    super(id);
    this.projectId = projectId;
    this.userId = userId;
    this.role = role;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
