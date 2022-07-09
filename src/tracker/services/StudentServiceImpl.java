package tracker.services;

import tracker.repository.DataBase;

import static tracker.util.Msg.*;

public class StudentServiceImpl implements StudentService {

    private final DataBase dataBase;
    private final AddPointsService addPointsService;
    private final AddStudentService addStudentService;
    private final FindService findService;
    private final StatisticService statisticService;

    private final NotifyService notifyService;

    public StudentServiceImpl() {
        this.dataBase = new DataBase();
        this.addPointsService = new AddPointsService(dataBase);
        this.addStudentService = new AddStudentService(dataBase);
        this.findService = new FindService(dataBase);
        this.statisticService = new StatisticService(dataBase);
        this.notifyService = new NotifyService(dataBase);
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
    public void statistics() {
        statisticService.statistics();
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

    @Override
    public void notification() {
        notifyService.notification();
    }

    @Override
    public void listaDemo() {
        dataBase.getStudents().forEach(System.out::println);
    }

}
