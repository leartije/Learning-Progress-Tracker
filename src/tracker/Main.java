package tracker;

import tracker.business.StudentServiceController;

public class Main {
    public static void main(String[] args) {

        new StudentServiceController().startService();
    }
}
