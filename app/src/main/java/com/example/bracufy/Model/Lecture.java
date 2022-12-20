package com.example.bracufy.Model;

import java.io.Serializable;

public class Lecture implements Serializable {
    public String courseName,url,backGroundPic,topicName;


    public Lecture(String courseName, String url, String backGroundPic, String topicName) {
        this.courseName = courseName;
        this.url = url;
        this.backGroundPic = backGroundPic;
        this.topicName = topicName;
    }

    public Lecture(String courseName, String url, String topicName) {
        this.courseName = courseName;
        this.url = url;
        this.topicName = topicName;
    }

    public Lecture(){

    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBackGroundPic() {
        return backGroundPic;
    }

    public void setBackGroundPic(String backGroundPic) {
        this.backGroundPic = backGroundPic;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
