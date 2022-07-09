package tracker.services;

import tracker.entity.Courses;
import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.util.CoursesComm;
import tracker.util.Msg;

import java.util.Comparator;
import java.util.Optional;

import static tracker.util.Util.*;
import static tracker.util.Util.getAll;

public class StatisticService {

    private final DataBase dataBase;

    public StatisticService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void statistics() {
        System.out.println(Msg.STATISTICS_MENU);
        generalStatistics();
        while (true) {
            String input = SCANNER.nextLine();
            if (Msg.BACK.equals(input)) {
                return;
            }

            switch (getCourses(input)) {
                case JAVA:
                    getJavaPointsForStudents();
                    break;
                case DSA:
                    getDSAPointsForStudents();
                    break;
                case DATABASES:
                    getDatabasePointsForStudents();
                    break;
                case SPRING:
                    getSpringPointsForStudents();
                    break;
                case UNKNOWN:
                    System.out.println(Msg.UNKNOWN_COURSE);
                    break;
            }

        }
    }

    private void getJavaPointsForStudents() {
        System.out.println(Msg.JAVA);
        System.out.println("id     points    completed");
        dataBase.getStudents().sort((Comparator.comparingInt(Student::getJavaPoints).reversed()
                .thenComparingLong(Student::getId)));

        dataBase.getStudents().stream()
                .filter(student -> student.getJavaPoints() > 0)
                .forEach(student -> System.out.printf("%d     %d     %.1f%%%n", student.getId(),
                        student.getJavaPoints(), getPercentage(student.getJavaPoints(), JAVA_MAX_POINTS)));

    }

    private void getDSAPointsForStudents() {
        System.out.println(Msg.DSA);
        System.out.println("id     points    completed");
        dataBase.getStudents().sort((Comparator.comparingInt(Student::getDsaPoints).reversed()));

        dataBase.getStudents().stream()
                .filter(student -> student.getDsaPoints() > 0)
                .forEach(student -> System.out.printf("%d     %d     %.1f%%%n", student.getId(),
                        student.getDsaPoints(), getPercentage(student.getDsaPoints(), DSA_MAX_POINTS)));

    }

    private void getDatabasePointsForStudents() {
        System.out.println(Msg.DATABASE);
        System.out.println("id     points    completed");
        dataBase.getStudents().sort((Comparator.comparingInt(Student::getDatabasePoints).reversed()));

        dataBase.getStudents().stream()
                .filter(student -> student.getDatabasePoints() > 0)
                .forEach(student -> System.out.printf("%d     %d     %.1f%%%n", student.getId(),
                        student.getDatabasePoints(), getPercentage(student.getDatabasePoints(), DATABASE_MAX_POINTS)));

    }

    private void getSpringPointsForStudents() {
        System.out.println(Msg.SPRING);
        System.out.println("id     points    completed");
        dataBase.getStudents().sort((Comparator.comparingInt(Student::getSpringPoints).reversed()));

        dataBase.getStudents().stream()
                .filter(student -> student.getSpringPoints() > 0)
                .forEach(student -> System.out.printf("%d     %d     %.1f%%%n", student.getId(),
                        student.getSpringPoints(), getPercentage(student.getSpringPoints(), SPRING_MAX_POINTS)));

    }


    private double getPercentage(int points, int max) {
        return ((double) points / (double) max * 100);
    }

    private CoursesComm getCourses(String input) {
        try {
            return CoursesComm.valueOf(input.strip().toUpperCase());
        } catch (IllegalArgumentException e) {
            return CoursesComm.UNKNOWN;
        }
    }

    private void generalStatistics() {
        System.out.printf(Msg.STATISTICS, getMostPopular(), getLeastPopular(), getMostActivity(),
                getLeastActivity(), getEasiest(), getHardest());
    }


    private String getMostPopular() {
        long max = maxEnrollment();
        if (max == 0) {
            return "n/a";
        }
        StringBuilder mostPopular = new StringBuilder();
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEnrolled() == max) {
                mostPopular.append(getAll().get(i).getName()).append(", ");
            }
        }
        return mostPopular.toString().trim();
    }

    private String getLeastPopular() {
        long min = minEnrollment();
        long max = maxEnrollment();
        if (min == 0 || min == max) {
            return "n/a";
        }
        StringBuilder leastPopular = new StringBuilder();
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEnrolled() == min) {
                leastPopular.append(getAll().get(i).getName()).append(", ");
            }
        }
        return leastPopular.toString().trim();
    }

    private String getMostActivity() {
        long max = maxActivity();
        if (max == 0) {
            return "n/a";
        }
        StringBuilder mostActivity = new StringBuilder();
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEnrolled() == max) {
                mostActivity.append(getAll().get(i).getName()).append(", ");
            }
        }
        return mostActivity.toString().trim();
    }

    private String getLeastActivity() {
        long min = minActivity();
        long max = maxActivity();
        if (min == 0 || min == max) {
            return "n/a";
        }
        StringBuilder leastActivity = new StringBuilder();
        for (int i = 0; i < getAll().size(); i++) {
            if (getAll().get(i).getEnrolled() == min) {
                leastActivity.append(getAll().get(i).getName()).append(", ");
            }
        }
        return leastActivity.toString().trim();
    }

    private String getEasiest() {
        String name = easiestCourse();
        if (name == null) {
            return "n/a";
        }

        return name;
    }

    private String getHardest() {
        String name = hardestCourse();
        if (name == null) {
            return "n/a";
        }

        return name;
    }

    private long maxEnrollment() {
        Optional<Courses> max = getAll().stream().max(Comparator.comparing(Courses::getEnrolled));
        return max.map(Courses::getEnrolled).orElse(0L);

    }

    private long minEnrollment() {
        Optional<Courses> min = getAll().stream().min(Comparator.comparing(Courses::getEnrolled));
        return min.map(Courses::getEnrolled).orElse(0L);

    }

    private long maxActivity() {
        Optional<Courses> max = getAll().stream().max(Comparator.comparing(Courses::getSubmissions));
        return max.map(Courses::getSubmissions).orElse(0L);
    }

    private long minActivity() {
        Optional<Courses> min = getAll().stream().min(Comparator.comparing(Courses::getSubmissions));
        return min.map(Courses::getSubmissions).orElse(0L);
    }

    private String easiestCourse() {
        Optional<Courses> max = getAll().stream()
                .max(Comparator.comparing(courses ->
                        (double) courses.getPoints() / (double) courses.getSubmissions()));

        if (max.get().getSubmissions() == 0) {
            return null;
        }

        return max.map(Courses::getName).orElse(null);
    }

    private String hardestCourse() {
        Optional<Courses> min = getAll().stream()
                .min(Comparator.comparing(courses ->
                        (double) courses.getPoints() / (double) courses.getSubmissions()));

        if (min.get().getSubmissions() == 0) {
            return null;
        }

        return min.map(Courses::getName).orElse(null);
    }


}
