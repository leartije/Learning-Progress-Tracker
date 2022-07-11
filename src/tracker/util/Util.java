package tracker.util;

import tracker.entity.Courses;

import java.util.*;

import static tracker.util.Msg.*;

public abstract class Util {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final int JAVA_MAX_POINTS = 600;
    public static final int DSA_MAX_POINTS = 400;
    public static final int DATABASE_MAX_POINTS = 480;
    public static final int SPRING_MAX_POINTS = 550;

    public static final Courses JAVA_STATISTICS = new Courses(JAVA);
    public static final Courses DSA_STATISTICS = new Courses(DSA);
    public static final Courses DATABASE_STATISTICS = new Courses(DATABASE);
    public static final Courses SPRING_STATISTICS = new Courses(SPRING);

    public static List<Courses> getAll() {
        List<Courses> list = new ArrayList<>();
        list.add(JAVA_STATISTICS);
        list.add(DSA_STATISTICS);
        list.add(DATABASE_STATISTICS);
        list.add(SPRING_STATISTICS);

        return list;
    }

}
