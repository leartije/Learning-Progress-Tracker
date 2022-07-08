package tracker.services;

import tracker.repository.DataBase;

import java.util.regex.Pattern;

public class StudentCredentialsChecker {

    public static final Pattern NAME_REGEX = Pattern.compile("^(?i)([a-z]+('|-)?[a-z]+)+");
    public static final Pattern SURNAME_REGEX = Pattern.compile("(?i)[a-z]+([ '-][a-z]+)*");
    public static final Pattern EMAIL_REGEX = Pattern.compile("^(?i)[a-z\\d._%+-]+@[a-z\\d.-]+\\.[a-z\\d]+$");

    public String[] parser(String input) {
        if (input == null || input.isEmpty()) {
            return new String[0];
        }

        String[] parseInput = input.strip().split("\\s");
        if (parseInput.length < 3) {
            return new String[0];
        }

        return parseInput;
    }

    public String[] getCredentials(String[] credentials) {
        String[] cred = new String[3];
        cred[0] = credentials[0];
        cred[2] = credentials[credentials.length - 1];

        StringBuilder lastName = new StringBuilder();
        for (int i = 1; i < credentials.length - 1; i++) {
            lastName.append(credentials[i]).append(" ");
        }

        cred[1] = lastName.toString().trim();

        return cred;
    }


    public boolean isValidName(String name) {
        return NAME_REGEX.matcher(name).matches();
    }

    public boolean isValidSurname(String surname) {
        return SURNAME_REGEX.matcher(surname).matches();
    }

    public boolean isValidEmail(String email) {
        return EMAIL_REGEX.matcher(email).matches();
    }

    public boolean isEmailAlreadyTaken(DataBase dataBase, String email) {
        return dataBase.getStudents().stream().anyMatch(student -> student.getEmail().equalsIgnoreCase(email));

    }

}
