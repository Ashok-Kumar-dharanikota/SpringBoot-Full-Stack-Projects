package com.application.project.model;

public class Task {
    int user_id;
    String Title;
    String Description;
    boolean status;

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public long getUser_id() {
        return user_id;
    }

    public boolean isStatus() {
        return status;
    }


    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
