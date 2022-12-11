package com.example.drshceduler;

public class Subject {
    private String Cabinet;
    private String Subject;
    private String Teacher;
    private String Day;
    private String Type;
    private String Week;
    private String Link;
    private String Time;
    private String Number;

    public Subject() {
    }

    public Subject(String cabinet,
                   String name,
                   String teacher,
                   String day,
                   String week,
                   String link,
                   String time) {
        this.Cabinet = cabinet;
        this.Subject = name;
        this.Teacher = teacher;
        this.Day = day;
        this.Week = week;
        this.Link = link;
        this.Time = time;
    }

    public String getCabinet() {
        return Cabinet;
    }

    public void setCabinet(String cabinet) {
        Cabinet = cabinet;
    }

    public String getSubject() {
        return Subject;
    }

    public void setSubject(String subject) {
        Subject = subject;
    }

    public String getTeacher() {
        return Teacher;
    }

    public void setTeacher(String teacher) {
        Teacher = teacher;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getWeek() {
        return Week;
    }

    public void setWeek(String week) {
        Week = week;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}
