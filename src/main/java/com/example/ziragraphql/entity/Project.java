package com.example.ziragraphql.entity;

public class Project extends BaseEntity {
  private String name;
  private String description;

  public Project() {
    super();
  }

  public Project(String id, String name, String description) {
    super(id);
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Project{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            '}';
  }
}
