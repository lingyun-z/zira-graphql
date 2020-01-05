package com.example.ziragraphql.entity;

public class Ticket {
  private String id;
  private String number;
  private String projectId;
  private String parentId;
  private String title;
  private String type;
  private String status;
  private Integer estimate;
  private String description;
  private String createdBy;
  private String assignee;
  private String createdDate;
  private String updateDate;

  public Ticket() {
  }

  public Ticket(String id, String number, String projectId, String parentId, String title, String type, String status, Integer estimate, String description, String createdBy, String assignee, String createdDate, String updateDate) {
    this.id = id;
    this.number = number;
    this.projectId = projectId;
    this.parentId = parentId;
    this.title = title;
    this.type = type;
    this.status = status;
    this.estimate = estimate;
    this.description = description;
    this.createdBy = createdBy;
    this.assignee = assignee;
    this.createdDate = createdDate;
    this.updateDate = updateDate;
  }

  @Override
  public String toString() {
    return "Ticket{" +
            "id='" + id + '\'' +
            ", number='" + number + '\'' +
            ", projectId='" + projectId + '\'' +
            ", parentId='" + parentId + '\'' +
            ", title='" + title + '\'' +
            ", type='" + type + '\'' +
            ", status='" + status + '\'' +
            ", estimate=" + estimate +
            ", description='" + description + '\'' +
            ", createdBy='" + createdBy + '\'' +
            ", assignee='" + assignee + '\'' +
            ", createdDate='" + createdDate + '\'' +
            ", updateDate='" + updateDate + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getProjectId() {
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Integer getEstimate() {
    return estimate;
  }

  public void setEstimate(Integer estimate) {
    this.estimate = estimate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getAssignee() {
    return assignee;
  }

  public void setAssignee(String assignee) {
    this.assignee = assignee;
  }

  public String getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(String createdDate) {
    this.createdDate = createdDate;
  }

  public String getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(String updateDate) {
    this.updateDate = updateDate;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }
}
