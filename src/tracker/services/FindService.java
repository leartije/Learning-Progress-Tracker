package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.services.check.PointsFormatCheck;
import tracker.util.Util;

import static tracker.util.Msg.*;

public class FindService {

    private final DataBase dataBase;
    private final PointsFormatCheck check;

    public FindService(DataBase dataBase) {
        this.dataBase = dataBase;
        this.check = new PointsFormatCheck();
    }

    public void findStudent() {
        System.out.println(FIND_MENU);
        while (true) {
            String input = Util.SCANNER.nextLine();
            if (BACK.equals(input)) {
                return;
            }

            long id = getId(input);
            Student searchedStudent = check.getStudentByID(id, dataBase);

            if (id == 0 || searchedStudent == null) {
                System.out.printf(NO_STUDENT_IS_FOUND_FOR_ID, input);
                continue;
            }

            System.out.printf(POINTS, id, searchedStudent.getJavaPoints(),
                    searchedStudent.getDsaPoints(), searchedStudent.getDatabasePoints(),
                    searchedStudent.getSpringPoints());
        }
    }

    private long getId(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
