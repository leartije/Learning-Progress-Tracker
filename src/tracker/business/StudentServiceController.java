package tracker.business;

import tracker.services.StudentService;
import tracker.services.StudentServiceImpl;
import tracker.util.Commands;
import tracker.util.Msg;
import tracker.util.Util;

import java.util.Locale;

public class StudentServiceController {

    private final StudentService studentService;

    public StudentServiceController() {
        this.studentService = new StudentServiceImpl();
    }

    public void startService() {
        System.out.println(Msg.WELCOME_MSG);
        while (true) {
            String input = Util.SCANNER.nextLine()
                    .replaceAll("\\s", "_")
                    .toUpperCase(Locale.ROOT);

            switch (getCommand(input)) {
                case ADD_STUDENTS:
                    studentService.addStudents();
                    break;
                case ADD_POINTS:
                    studentService.addPoints();
                    break;
                case FIND:
                    studentService.find();
                    break;
                case LIST:
                    studentService.list();
                    break;
                case BACK:
                    System.out.println(Msg.EXIT_NOT_BACK);
                    break;
                case EXIT:
                    System.exit(0);
                    break;
                case LISTA:
                    studentService.listaDemo();
                    break;
                case UNKNOWN:
                    System.out.println(Msg.UNKNOWN_COMMAND);
                    break;
            }

        }
    }

    private Commands getCommand(String input) {
        try {
            return Commands.valueOf(input);
        } catch (IllegalArgumentException e) {
            return Commands.UNKNOWN;
        }
    }

}
