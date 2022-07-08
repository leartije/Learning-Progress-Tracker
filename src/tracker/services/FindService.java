package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.util.Msg;
import tracker.util.Util;

public class FindService {

    private final DataBase dataBase;
    private final PointsFormatChecker checker;

    public FindService(DataBase dataBase) {
        this.dataBase = dataBase;
        this.checker = new PointsFormatChecker();
    }

    public void findStudent() {
        System.out.println(Msg.FIND_MENU);
        while (true) {
            String input = Util.SCANNER.nextLine();
            if ("back".equals(input)) {
                return;
            }

            long id = getId(input);
            Student searchedStudent = checker.getStudentByID(id, dataBase);

            if (id == 0 || searchedStudent == null) {
                System.out.printf(Msg.NO_STUDENT_IS_FOUND_FOR_ID, input);
                continue;
            }

            System.out.printf(Msg.POINTS, id, searchedStudent.getJavaPoints(),
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
