package tracker.entity;

public class Courses {

    private String name;
    private long points;
    private long submissions;
    private long enrolled;

    public Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points += points;
    }

    public long getSubmissions() {
        return submissions;
    }

    public void setSubmissions(long submissions) {
        this.submissions += submissions;
    }

    public long getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(long enrolled) {
        this.enrolled += enrolled;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                ", points=" + points +
                ", submissions=" + submissions +
                ", enrolled=" + enrolled +
                '}';
    }
}
