package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.util.Msg;

public class NotifyService {

    private final DataBase dataBase;

    public NotifyService(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public void notification() {

        int count = 0;

        for (int i = 0; i < dataBase.getStudents().size(); i++) {
            boolean atLeastOne = false;
            Student current = dataBase.getStudents().get(i);
            if (current.isJavaCourseCompleted() && !current.isNotify()) {
                System.out.printf(Msg.NOTIFY, current.getEmail(), (current.getName() + " " + current.getLastName()), "Java");
                atLeastOne = true;
            }
            if (current.isDSACourseCompleted() && !current.isNotify()) {
                System.out.printf(Msg.NOTIFY, current.getEmail(), (current.getName() + " " + current.getLastName()), "DSA");
                atLeastOne = true;
            }
            if (current.isDatabaseCourseComplete() && !current.isNotify()) {
                System.out.printf(Msg.NOTIFY, current.getEmail(), (current.getName() + " " + current.getLastName()), "Database");
                atLeastOne = true;
            }
            if (current.isSpringCourseComplete() && !current.isNotify()) {
                System.out.printf(Msg.NOTIFY, current.getEmail(), (current.getName() + " " + current.getLastName()), "Spring");
                atLeastOne = true;
            }

            if (atLeastOne) {
                current.setNotify(true);
                count++;
            }
        }

        System.out.printf(Msg.TOTAL_STUDENTS_HAVE_BEEN_NOTIFIED, count);
    }

}
