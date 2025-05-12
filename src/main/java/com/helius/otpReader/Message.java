package com.helius.otpReader;

public class Message {
    private String title;


    private String dateTime;

    private String content;


    public Message(String title, String dateTime, String content) {
        this.title = title;
        this.dateTime = dateTime;
        this.content = content;
    }

    public Message(String title, String content) {
        this.title = title;
        this.dateTime = "";
        this.content = content;
    }

    public Message(String content) {
        this.title = "";
        this.dateTime = "";
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
