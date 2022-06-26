package com.example.kampuskonnect.model;

public class chatlist {
    private String userId;
    private String username;
    private String description;
    private String date;
     private int imageprofile;

    public chatlist() {
    }

    public chatlist(String userId, String username, String description, String date, int imageprofile) {
        this.userId = userId;
        this.username = username;
        this.description = description;
        this.date = date;
        this.imageprofile = imageprofile;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageprofile() {
        return imageprofile;
    }

    public void setImageprofile(int imageprofile) {
        this.imageprofile = imageprofile;
    }
}
