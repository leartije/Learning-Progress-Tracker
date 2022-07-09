package tracker.util;

import tracker.entity.Courses;

import java.util.*;

public abstract class Util {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final int JAVA_MAX_POINTS = 600;
    public static final int DSA_MAX_POINTS = 400;
    public static final int DATABASE_MAX_POINTS = 480;
    public static final int SPRING_MAX_POINTS = 550;

    public static final Courses JAVA_STATISTICS = new Courses("Java");
    public static final Courses DSA_STATISTICS = new Courses("DSA");
    public static final Courses DATABASE_STATISTICS = new Courses("Databases");
    public static final Courses SPRING_STATISTICS = new Courses("Spring");

    public static List<Courses> getAll() {
        List<Courses> lista = new ArrayList<>();
        lista.add(JAVA_STATISTICS);
        lista.add(DSA_STATISTICS);
        lista.add(DATABASE_STATISTICS);
        lista.add(SPRING_STATISTICS);

        return lista;
    }

}
