package tracker.services.check;

import tracker.entity.Student;
import tracker.repository.DataBase;

public class PointsFormatCheck {

    public String[] parsePoints(String points) {
        if (points == null || points.isEmpty()) {
            return new String[0];
        }
        String[] parsePoints = points.strip().split("\\s");
        if (points.length() < 5) {
            return new String[0];
        }
        return parsePoints;
    }

    public boolean isPointsFormatCorrect(String[] points) {
        if (points.length != 5) {
            return false;
        }

        try {
            for (int i = 1; i < points.length; i++) {
                int temp = Integer.parseInt(points[i]);
                if (temp < 0) {
                    throw new NumberFormatException();
                }
            }
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public long getId(String[] id) {
        try {
            return Long.parseLong(id[0]);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public Student getStudentByID(long id, DataBase dataBase) {
        for (int i = 0; i < dataBase.getStudents().size(); i++) {
            if (dataBase.getStudents().get(i).getId() == id) {
                return dataBase.getStudents().get(i);
            }
        }
        return null;
    }


    public int[] getPoints(String[] points) {
        int[] po = new int[4];
        for (int i = 1; i < points.length; i++) {
            po[i - 1] = Integer.parseInt(points[i]);
        }
        return po;
    }

}
