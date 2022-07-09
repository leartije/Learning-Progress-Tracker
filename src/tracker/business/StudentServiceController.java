package tracker.business;

import tracker.entity.Courses;
import tracker.services.StudentService;
import tracker.services.StudentServiceImpl;
import tracker.util.Commands;
import tracker.util.Msg;
import tracker.util.Util;

import java.util.List;
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
                    .strip()
                    .replaceAll("\\s", "_")
                    .toUpperCase(Locale.ROOT);

            if (input.isEmpty() || input.isBlank()) {
                System.out.println(Msg.NO_INPUT);
                continue;
            }

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
                case STATISTICS:
                    studentService.statistics();
                    break;
                case NOTIFY:
                    studentService.notification();
                    break;
                case BACK:
                    System.out.println(Msg.EXIT_NOT_BACK);
                    break;
                case EXIT:
                    System.out.println(Msg.BYE);
                    System.exit(0);
                    break;
                case LISTA:
                    List<Courses> all = Util.getAll();
                    System.out.println(all);
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
