package com.example.drshceduler;

public class User {
    private String StudentID;
    private String FullName;
    private String Faculty;
    private String Specialty;
    private String Group;
    private String Term;
    private String FormOfEducation;
    private String TermOfEducation;
    private String Email;
    private String UserID;
    private String Language;
    private boolean ThemeDark;
    private int TimeNotify;
    private boolean Notify;

    public User() {
    }

    public User(String fullName, String studentID, String faculty, String specialty, String group, String term,
                String formOfEducation, String termOfEducation, String email, String userID) {
        this.StudentID = studentID;
        this.FullName = fullName;
        this.Faculty = faculty;
        this.Specialty = specialty;
        this.Group = group;
        this.Term = term;
        this.FormOfEducation = formOfEducation;
        this.TermOfEducation = termOfEducation;
        this.Email = email;
        this.UserID = userID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public void setFaculty(String faculty) {
        Faculty = faculty;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public void setGroup(String group) {
        Group = group;
    }

    public void setTerm(String term) {
        Term = term;
    }

    public void setFormOfEducation(String formOfEducation) {
        FormOfEducation = formOfEducation;
    }

    public void setTermOfEducation(String termOfEducation) {
        TermOfEducation = termOfEducation;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getUserID() {
        return UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getFaculty() {
        return Faculty;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public String getGroup() {
        return Group;
    }

    public String getTerm() {
        return Term;
    }

    public String getFormOfEducation() {
        return FormOfEducation;
    }

    public String getTermOfEducation() {
        return TermOfEducation;
    }

    public String getEmail() {
        return Email;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public boolean isThemeDark() {
        return ThemeDark;
    }

    public void setThemeDark(boolean themeDark) {
        ThemeDark = themeDark;
    }

    public int getTimeNotify() {
        return TimeNotify;
    }

    public void setTimeNotify(int timeNotify) {
        TimeNotify = timeNotify;
    }

    public boolean isNotify() {
        return Notify;
    }

    public void setNotify(boolean notify) {
        Notify = notify;
    }

}
