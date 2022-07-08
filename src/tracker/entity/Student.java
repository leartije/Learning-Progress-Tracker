package tracker.entity;

public class Student {

    private long id;
    private String name;
    private String lastName;
    private String email;

    private int javaPoints;
    private int dsaPoints;
    private int databasePoints;
    private int springPoints;

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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", javaPoints=" + javaPoints +
                ", dsaPoints=" + dsaPoints +
                ", databasePoints=" + databasePoints +
                ", springPoints=" + springPoints +
                '}';
    }
}
