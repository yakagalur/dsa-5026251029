package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> courseMap = new LinkedHashMap<>();
        int failed = 0;

        System.out.println("===== Enrollment Checks =====");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] parts = line.split(" ");

            String operation = parts[0];
            String courseCode = parts[1];

            if (operation.equalsIgnoreCase("REGISTER")) {
                int studentCount = Integer.parseInt(parts[2]);
                if (studentCount > 0) {
                    if (!courseMap.containsKey(courseCode)) {
                        courseMap.put(courseCode, studentCount);
                    } else {
                        int newStudent = courseMap.get(courseCode) + studentCount;
                        courseMap.remove(courseCode);
                        courseMap.put(courseCode, newStudent);
                    }
                } else {
                    failed++;
                }
            } else if (operation.equalsIgnoreCase("WITHDRAW") && courseMap.containsKey(courseCode)) {
                int studentCount = Integer.parseInt(parts[2]);
                if (courseMap.get(courseCode) > studentCount && studentCount >= 0) {
                    int newStudent = courseMap.get(courseCode) - studentCount;
                    courseMap.remove(courseCode);
                    courseMap.put(courseCode, newStudent);
                } else {
                    failed++;
                }
            } else if (operation.equalsIgnoreCase("CHECK")) {
                String enrollmentCount = "";
                if (courseMap.get(courseCode) == null) {
                    enrollmentCount = "Not found";
                } else {
                    enrollmentCount = Integer.toString(courseMap.get(courseCode));
                }
                System.out.println(courseCode + " : " + enrollmentCount);
            } else {
                failed++;
            }
        }

        System.out.println("\n===== Final Enrollment =====");
        for (String key : courseMap.keySet()) {
            System.out.println(key + ": " + courseMap.get(key) + " students");
        }
        System.out.println("\nRejected operation: " + failed);
    }
}