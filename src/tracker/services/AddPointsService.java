package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.util.CoursesComm;

import static tracker.util.Msg.*;
import static tracker.util.Util.*;

public class AddPointsService {

    private final int ADD_ONE_SUBMISSION = 1;

    private final DataBase dataBase;
    private final PointsFormatChecker pointsFormatChecker;

    public AddPointsService(DataBase dataBase) {
        this.dataBase = dataBase;
        this.pointsFormatChecker = new PointsFormatChecker();
    }

    public void addPoints() {
        System.out.println(ADD_POINTS_MENU);
        while (true) {
            String input = SCANNER.nextLine();
            if (BACK.equalsIgnoreCase(input)) {
                return;
            }

            String[] points = pointsFormatChecker.parsePoints(input);
            if (points.length == 0 || !pointsFormatChecker.isPointsFormatCorrect(points)) {
                System.out.println(INCORRECT_POINT_FORMAT);
                continue;
            }

            long id = pointsFormatChecker.getId(points);
            Student searchedStudent = pointsFormatChecker.getStudentByID(id, dataBase);
            if (searchedStudent == null) {
                System.out.printf(NO_STUDENT_IS_FOUND_FOR_ID, points[0]);
                continue;
            }

            int[] point = pointsFormatChecker.getPoints(points);
            addJavaPoints(point, searchedStudent, CoursesComm.JAVA);
            addJavaPoints(point, searchedStudent, CoursesComm.DSA);
            addJavaPoints(point, searchedStudent, CoursesComm.DATABASES);
            addJavaPoints(point, searchedStudent, CoursesComm.SPRING);

            System.out.println(POINTS_UPDATED);

        }
    }

    private void addJavaPoints(int[] points, Student student, CoursesComm coursesComm) {
        switch (coursesComm) {
            case JAVA:
                int javaPoints = points[0];
                if (javaPoints > 0) {
                    JAVA_STATISTICS.setEnrolled(student.getJavaPoints() == 0 ? ADD_ONE_SUBMISSION : 0);

                    student.setJavaPoints(javaPoints);
                    student.setJavaSubmissions(ADD_ONE_SUBMISSION);
                    student.setJavaCourseCompleted(student.getJavaPoints() >= JAVA_MAX_POINTS);

                    JAVA_STATISTICS.setPoints(javaPoints);
                    JAVA_STATISTICS.setSubmissions(ADD_ONE_SUBMISSION);
                    break;
                }
                break;
            case DSA:
                int dsaPoints = points[1];
                if (dsaPoints > 0) {
                    DSA_STATISTICS.setEnrolled(student.getDsaPoints() == 0 ? ADD_ONE_SUBMISSION : 0);

                    student.setDsaPoints(dsaPoints);
                    student.setDsaSubmissions(ADD_ONE_SUBMISSION);
                    student.setDSACourseCompleted(student.getDsaPoints() >= DSA_MAX_POINTS);

                    DSA_STATISTICS.setPoints(dsaPoints);
                    DSA_STATISTICS.setSubmissions(ADD_ONE_SUBMISSION);
                    break;
                }
                break;
            case DATABASES:
                int databasePoints = points[2];
                if (databasePoints > 0) {
                    DATABASE_STATISTICS.setEnrolled(student.getDatabasePoints() == 0 ? ADD_ONE_SUBMISSION : 0);

                    student.setDatabasePoints(databasePoints);
                    student.setDatabaseSubmissions(ADD_ONE_SUBMISSION);
                    student.setDatabaseCourseComplete(student.getDatabasePoints() >= DATABASE_MAX_POINTS);

                    DATABASE_STATISTICS.setPoints(databasePoints);
                    DATABASE_STATISTICS.setSubmissions(ADD_ONE_SUBMISSION);
                    break;
                }
                break;
            case SPRING:
                int springPoints = points[3];
                if (springPoints > 0) {
                    SPRING_STATISTICS.setEnrolled(student.getSpringPoints() == 0 ? ADD_ONE_SUBMISSION : 0);

                    student.setSpringPoints(springPoints);
                    student.setSpringSubmissions(ADD_ONE_SUBMISSION);
                    student.setSpringCourseComplete(student.getSpringPoints() >= SPRING_MAX_POINTS);

                    SPRING_STATISTICS.setPoints(springPoints);
                    SPRING_STATISTICS.setSubmissions(ADD_ONE_SUBMISSION);
                    break;
                }
                break;
        }
    }



}
