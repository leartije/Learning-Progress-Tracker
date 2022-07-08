package tracker.services;

import tracker.repository.DataBase;

import static tracker.util.Msg.*;

public class StudentServiceImpl implements StudentService {

    private final DataBase dataBase;
    private final AddPointsService addPointsService;
    private final AddStudentService addStudentService;
    private final FindService findService;

    public StudentServiceImpl() {
        this.dataBase = new DataBase();
        this.addPointsService = new AddPointsService(dataBase);
        this.addStudentService = new AddStudentService(dataBase);
        this.findService = new FindService(dataBase);
    }

    @Override
    public void addStudents() {
        addStudentService.addStudent();
    }

    @Override
    public void addPoints() {
        addPointsService.addPoints();
    }

    @Override
    public void find() {
        findService.findStudent();
    }

    @Override
    public void listaDemo() {
        dataBase.getStudents().forEach(System.out::println);
    }

    @Override
    public void back() {
        System.out.printf(NUM_OF_STUDENTS_IN_DB, dataBase.getStudents().size());
    }

    @Override
    public void list() {
        if (dataBase.getStudents().size() == 0) {
            System.out.println(NO_STUDENTS_FOUND);
            return;
        }
        System.out.println(STUDENTS);
        dataBase.getStudents().forEach(student -> System.out.println(student.getId()));
    }

}
