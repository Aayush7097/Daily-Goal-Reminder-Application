Daily Goal Reminder (Java Console Application)

A simple Java-based console application that allows users to set daily goals, view them, mark them as completed, and get motivational reminders. This project was developed as part of my internship to practice Java basics, user interaction, file handling, and menu-driven applications.

Features:

Display a welcome message with current date and time

Morning/Evening greeting based on system time

Add new goals for the day

View all added goals with status (✓ Completed / ✗ Pending)

Mark goals as completed

Exit the program safely

Motivational quotes on startup

Color-coded console output (using ANSI escape codes)

Optional file handling: Save and load goals from goals.txt

Project Structure:

DailyGoalReminder.java → Main application source code

goals.txt → File used to save and load goals

README.txt → Project documentation

Technologies Used:

Language: Java (SE 8 or higher)

IDE: IntelliJ IDEA / Eclipse / VS Code (any Java-supported IDE)

Java Classes & Packages:

Scanner → User input handling

ArrayList → Dynamic storage of goals

java.time (LocalDate, LocalTime, DateTimeFormatter) → Date & time handling

FileReader, FileWriter, BufferedReader, BufferedWriter → File I/O

Random → Random motivational quote

Concepts Practiced:

Java program structure & syntax

User input and output handling with Scanner

Loops (while, for) and conditionals (if, switch)

Dynamic storage with ArrayList

String manipulation and formatting

Date and time handling with java.time API

File handling for saving/loading data

Modular programming (methods: addGoal(), viewGoals(), markGoalCompleted())

Console UI design (menu-driven navigation + color-coded output)

How to Run:

Clone or download the project

Open the project in your IDE (IntelliJ, Eclipse, or VS Code)

Compile and run using:
javac DailyGoalReminder.java
java DailyGoalReminder

Follow the menu instructions in the console

Sample Usage:

==============================
DAILY GOAL REMINDER APP
Good Morning! Today is 2025-08-30 | 09:45 AM
Motivation: Small steps every day lead to big results.

--- MENU ---

Add a New Goal

View Today's Goals

Mark Goal as Completed

Exit
Enter your choice:

Example Output:

Adding a goal:
Enter your goal: Finish Java Assignment
Goal added successfully!

Viewing goals:
Today's Goals:

Finish Java Assignment [✗ Pending]

Marking as completed:
Enter the goal number to mark as completed: 1
Goal marked as completed!

File Handling:

Goals are saved in goals.txt automatically when exiting the program.

Next time you run the program, it loads your saved goals.

File format:
Finish Java Assignment|true
Complete internship task|false

Future Enhancements:

Add deadlines and reminders with system notifications

Categorize goals (Work, Study, Health)

Export goals in CSV/JSON format

Add password-protected login for multiple users

Acknowledgment:
This project was developed as part of my internship program to strengthen skills in:

Java programming

File handling

Console UI design

Problem-solving with modular methods

Author: Aayush
