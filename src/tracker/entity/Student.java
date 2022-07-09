package tracker.entity;

public class Student {

    private long id;
    private String name;
    private String lastName;
    private String email;

    private int javaPoints;
    private int javaSubmissions;
    private boolean isJavaCourseCompleted;
    private int dsaPoints;
    private int dsaSubmissions;
    private boolean isDSACourseCompleted;
    private int databasePoints;
    private int databaseSubmissions;
    private boolean isDatabaseCourseComplete;
    private int springPoints;
    private int springSubmissions;
    private boolean isSpringCourseComplete;

    private boolean isNotify = false;



    public Student() {
    }

    public Student(long id, String name, String lastName, String email) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getJavaPoints() {
        return javaPoints;
    }

    public void setJavaPoints(int javaPoints) {
        this.javaPoints += javaPoints;
    }

    public int getDsaPoints() {
        return dsaPoints;
    }

    public void setDsaPoints(int dsaPoints) {
        this.dsaPoints += dsaPoints;
    }

    public int getDatabasePoints() {
        return databasePoints;
    }

    public void setDatabasePoints(int databasePoints) {
        this.databasePoints += databasePoints;
    }

    public int getSpringPoints() {
        return springPoints;
    }

    public void setSpringPoints(int springPoints) {
        this.springPoints += springPoints;
    }

    public void setJavaSubmissions(int javaSubmissions) {
        this.javaSubmissions += javaSubmissions;
    }

    public void setDsaSubmissions(int dsaSubmissions) {
        this.dsaSubmissions += dsaSubmissions;
    }

    public void setDatabaseSubmissions(int databaseSubmissions) {
        this.databaseSubmissions += databaseSubmissions;
    }

    public void setSpringSubmissions(int springSubmissions) {
        this.springSubmissions += springSubmissions;
    }

    public boolean isJavaCourseCompleted() {
        return isJavaCourseCompleted;
    }

    public void setJavaCourseCompleted(boolean javaCourseCompleted) {
        isJavaCourseCompleted = javaCourseCompleted;
    }

    public boolean isDSACourseCompleted() {
        return isDSACourseCompleted;
    }

    public void setDSACourseCompleted(boolean DSACourseCompleted) {
        isDSACourseCompleted = DSACourseCompleted;
    }

    public boolean isDatabaseCourseComplete() {
        return isDatabaseCourseComplete;
    }

    public void setDatabaseCourseComplete(boolean databaseCourseComplete) {
        isDatabaseCourseComplete = databaseCourseComplete;
    }

    public boolean isSpringCourseComplete() {
        return isSpringCourseComplete;
    }

    public void setSpringCourseComplete(boolean springCourseComplete) {
        isSpringCourseComplete = springCourseComplete;
    }

    public boolean isNotify() {
        return isNotify;
    }

    public void setNotify(boolean notify) {
        isNotify = notify;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", javaPoints=" + javaPoints +
                ", javaSubmissions=" + javaSubmissions +
                ", dsaPoints=" + dsaPoints +
                ", dsaSubmissions=" + dsaSubmissions +
                ", databasePoints=" + databasePoints +
                ", databaseSubmissions=" + databaseSubmissions +
                ", springPoints=" + springPoints +
                ", springSubmissions=" + springSubmissions +
                '}';
    }
}
