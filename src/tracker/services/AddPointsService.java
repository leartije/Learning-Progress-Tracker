package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;

import static tracker.util.Msg.*;
import static tracker.util.Util.SCANNER;

public class AddPointsService {

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
            if ("back".equalsIgnoreCase(input)) {
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
                System.out.printf(NO_STUDENT_IS_FOUND_FOR_ID, id);
                continue;
            }

            int[] point = pointsFormatChecker.getPoints(points);
            searchedStudent.setJavaPoints(point[0]);
            searchedStudent.setDsaPoints(point[1]);
            searchedStudent.setDatabasePoints(point[2]);
            searchedStudent.setSpringPoints(point[3]);
            System.out.println(POINTS_UPDATED);

        }
    }

}
