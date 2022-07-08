package tracker.services;

import tracker.entity.Student;
import tracker.repository.DataBase;
import tracker.util.Util;

import static tracker.util.Msg.*;

public class AddStudentService {

    private final DataBase dataBase;
    private final StudentCredentialsChecker credentialsChecker;

    public AddStudentService(DataBase dataBase) {
        this.dataBase = dataBase;
        this.credentialsChecker = new StudentCredentialsChecker();
    }

    public void addStudent() {
        System.out.println(ADD_STUDENTS_MENU);
        int count = 0;
        while (true) {
            String input = Util.SCANNER.nextLine();
            if ("back".equalsIgnoreCase(input)) {
                System.out.printf(NUM_OF_STUDENTS_IN_DB, count);
                return;
            }

            String[] parse = credentialsChecker.parser(input);
            if (parse.length == 0) {
                System.out.println(INCORRECT_CREDENTIALS);
                continue;
            }

            String[] getCred = credentialsChecker.getCredentials(parse);
            String name = getCred[0];
            String lastName = getCred[1];
            String email = getCred[2];

            if (!credentialsChecker.isValidName(name)) {
                System.out.println(INCORRECT_FIRST_NAME);
                continue;
            }
            if (!credentialsChecker.isValidSurname(lastName)) {
                System.out.println(INCORRECT_LAST_NAME);
                continue;
            }
            if (!credentialsChecker.isValidEmail(email)) {
                System.out.println(INCORRECT_EMAIL);
                continue;
            }
            if (credentialsChecker.isEmailAlreadyTaken(dataBase, email)) {
                System.out.println(EMAIL_ALREADY_TAKEN);
                continue;
            }

            Student student = new Student(generateId(), name, lastName, email);
            dataBase.getStudents().add(student);
            count++;
            System.out.println(THE_STUDENT_HAS_BEEN_ADDED);
        }
    }

    private long generateId() {
        if (dataBase.getStudents().size() == 0) {
            return 10000L;
        }
        Student student = dataBase.getStudents().get(dataBase.getStudents().size() - 1);
        return student.getId() + 1;
    }
}
