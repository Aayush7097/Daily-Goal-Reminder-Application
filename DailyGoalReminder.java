import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DailyGoalReminder {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<String> goals = new ArrayList<>();
    private static final ArrayList<Boolean> completed = new ArrayList<>();
    private static final String FILE_NAME = "goals.txt";

    private static final String[] quotes = {
            "Believe you can and you're halfway there.",
            "Small steps every day lead to big results.",
            "Your limitation—it's only your imagination.",
            "Push yourself, because no one else is going to do it for you.",
            "Great things never come from comfort zones."
    };

    public static void main(String[] args) {
        displayWelcomeMessage();
        loadGoalsFromFile();  // optional file handling
        int choice;
        do {
            showMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    addGoal();
                    break;
                case 2:
                    viewGoals();
                    break;
                case 3:
                    markGoalCompleted();
                    break;
                case 4:
                    saveGoalsToFile();
                    System.out.println("\u001B[32mThank you for using Daily Goal Reminder! Stay motivated!\u001B[0m");
                    break;
                default:
                    System.out.println("Invalid choice, please try again!");
            }
        } while (choice != 4);
    }

    private static void displayWelcomeMessage() {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("hh:mm a");

        String greeting = (now.getHour() < 12) ? "Good Morning!" : "Good Evening!";
        System.out.println("\n==============================");
        System.out.println("   DAILY GOAL REMINDER APP    ");
        System.out.println("==============================");
        System.out.println(greeting + " Today is " + today + " | " + now.format(timeFormat));
        System.out.println("Motivation: " + quotes[new Random().nextInt(quotes.length)]);
        System.out.println("==============================\n");
    }

    private static void showMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Add a New Goal");
        System.out.println("2. View Today's Goals");
        System.out.println("3. Mark Goal as Completed");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void addGoal() {
        System.out.print("Enter your goal: ");
        String goal = scanner.nextLine();
        goals.add(goal);
        completed.add(false);
        System.out.println("\u001B[34mGoal added successfully!\u001B[0m");
    }

    private static void viewGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals added for today.");
            return;
        }
        System.out.println("\nToday's Goals:");
        for (int i = 0; i < goals.size(); i++) {
            String status = completed.get(i) ? "\u001B[32m✓ Completed\u001B[0m" : "\u001B[31m✗ Pending\u001B[0m";
            System.out.println((i + 1) + ". " + goals.get(i) + " [" + status + "]");
        }
    }

    private static void markGoalCompleted() {
        viewGoals();
        if (goals.isEmpty()) return;
        System.out.print("Enter the goal number to mark as completed: ");
        int index = getUserChoice() - 1;
        if (index >= 0 && index < goals.size()) {
            completed.set(index, true);
            System.out.println("\u001B[32mGoal marked as completed!\u001B[0m");
        } else {
            System.out.println("Invalid goal number.");
        }
    }

    // Optional file handling - Save and Load
    private static void saveGoalsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 0; i < goals.size(); i++) {
                writer.write(goals.get(i) + "|" + completed.get(i));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving goals: " + e.getMessage());
        }
    }

    private static void loadGoalsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                goals.add(parts[0]);
                completed.add(Boolean.parseBoolean(parts[1]));
            }
        } catch (IOException e) {
            System.out.println("Error loading goals: " + e.getMessage());
        }
    }
}
