package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;

import static tracker.util.Msg.*;

public class NotifyService {

    private final DataBase dataBase;

    public NotifyService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void notification() {

        int numStudentsToNotify = 0;

        for (int i = 0; i < dataBase.getStudents().size(); i++) {
            boolean atLeastOne = false;

            Student current = dataBase.getStudents().get(i);
            String fullName = current.getName() + " " + current.getLastName();

            if (current.isJavaCourseCompleted() && !current.isNotify()) {
                System.out.printf(NOTIFY, current.getEmail(), fullName, JAVA);
                atLeastOne = true;
            }
            if (current.isDSACourseCompleted() && !current.isNotify()) {
                System.out.printf(NOTIFY, current.getEmail(), fullName, DSA);
                atLeastOne = true;
            }
            if (current.isDatabaseCourseComplete() && !current.isNotify()) {
                System.out.printf(NOTIFY, current.getEmail(), fullName, DATABASE);
                atLeastOne = true;
            }
            if (current.isSpringCourseComplete() && !current.isNotify()) {
                System.out.printf(NOTIFY, current.getEmail(), fullName, SPRING);
                atLeastOne = true;
            }

            if (atLeastOne) {
                current.setNotify(true);
                numStudentsToNotify++;
            }
        }

        System.out.printf(TOTAL_STUDENTS_HAVE_BEEN_NOTIFIED, numStudentsToNotify);
    }

}
