import java.util.*;

public class Main {


    public static void mainMenu() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\033[1m|\t\t\tWELCOME TO GDSE MARKS MANAGEMENT SYSTEM\t\t\t|\033[0m");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println();
        System.out.print("[1] Add New Student\t\t\t");
        System.out.println("[2] Add New Student with marks");
        System.out.print("[3] Add Marks\t\t\t\t");
        System.out.println("[4] Update Student Details");
        System.out.print("[5] Update Marks\t\t\t");
        System.out.println("[6] Delete Student");
        System.out.print("[7] Print Student Details\t\t");
        System.out.println("[8] Print Student Ranks");
        System.out.print("[9] Best In Programming Fundamentals\t");
        System.out.println("[10] Best In Database Management Systems");
        System.out.println();
    }

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }

    public static String[][] addStudents(String[][] ar) {
        Scanner input = new Scanner(System.in);
        String[][] temp = new String[ar.length + 1][2];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < 2; j++) {
                temp[i][j] = ar[i][j];
            }
        }
        ar = temp;
        int row = ar.length - 1;
        System.out.print("Enter Student ID   : ");
        ar[row][0] = input.next();
        for (int i = 0; i < ar.length - 1; i++) {
            while (ar[row][0].equals(ar[i][0])) {
                System.out.println("The Student ID already exists");
                System.out.println();
                System.out.print("Enter Student ID   :");
                ar[row][0] = input.next();
            }
        }
        System.out.print("Enter Student Name : ");
        ar[row][1] = input.next();
        return ar;
    }

    public static int[][] setValue(int[][] xr) {
        int[][] temp = new int[xr.length + 1][3];
        for (int i = 0; i < xr.length; i++) {
            temp[i][0] = xr[i][0];
            temp[i][1] = xr[i][1];
            temp[i][2] = xr[i][2];
        }
        temp[xr.length][2] = 1;
        return temp;
    }

    public static int[][] addMarks(int[][] ar) {
        Scanner input = new Scanner(System.in);
        int[][] tempMarks = new int[ar.length + 1][3];
        for (int i = 0; i < ar.length; i++) {
            tempMarks[i] = ar[i];
        }
        int line = tempMarks.length - 1;
        System.out.print("\nProgramming Fundamentals Marks   : ");
        tempArray(input, tempMarks, line);
        System.out.print("\nMarks have been added succesfully. Do you want to add marks for a new student (Y/n): ");
        return tempMarks;
    }

    private static void tempArray(Scanner input, int[][] tempMarks, int line) {
        tempMarks[line][0] = input.nextInt();
        while (tempMarks[line][0] > 100 || tempMarks[line][0] < 0) {
            System.out.println("Invalid marks, please enter correct marks.");
            System.out.println();
            System.out.print("Programming Fundamentals Marks   : ");
            tempMarks[line][0] = input.nextInt();
        }
        System.out.print("Database Management System Marks : ");
        tempMarks[line][1] = input.nextInt();
        while (tempMarks[line][1] > 100 || tempMarks[line][1] < 0) {
            System.out.println("Invalid marks, please enter correct marks.");
            System.out.println();
            System.out.print("Database Management System Marks : ");
            tempMarks[line][1] = input.nextInt();
        }
    }

    public static int[][] addOnlyMarks(String[][] ar, int[][] xr) {

        char ch = 'Y';
        mainloop:
        while (true) {
            Scanner input = new Scanner(System.in);

            System.out.print("Enter Student ID   : ");
            String key = input.next();
            int index = -1;

            for (int i = 0; i < ar.length; i++) {
                if (ar[i][0].equals(key)) {
                    if (xr[i][2] == 0) {
                        System.out.println("This student's marks have been already added.");
                        System.out.println("If you want to update the marks. please use [5] Update Marks option.");
                        System.out.println();
                        System.out.print("Do you want to add marks for another student? (Y/n) ");
                        ch = input.next().charAt(0);
                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                        if (ch == 'Y') {
                            clearConsole();
                            System.out.println("--------------------------------------------------------------------------------");
                            System.out.println("\033[1m|\t\t\t\tADD MARKS\t\t\t\t\t|\033[0m");
                            System.out.println("--------------------------------------------------------------------------------");
                            continue mainloop;
                        }
                        if (ch == 'n') {
                            break mainloop;
                        }
                    }
                    System.out.println("Student Name     : " + ar[i][1]);
                    System.out.println();
                    System.out.print("Programming Fundamentals Marks   : ");
                    tempArray(input, xr, i);
                    xr[i][2] = 0;
                    System.out.print("Marks have been added. Do you want to add marks for another student (Y/n) ");
                    ch = input.next().charAt(0);
                    if (ch == 'Y') {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tADD MARKS\t\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        continue mainloop;
                    }
                    if (ch == 'n') {
                        break mainloop;
                    }
                }
            }
            System.out.println("Invalid ID.");
            System.out.println();
            System.out.print("Do you want to add marks for another student? (Y/n) ");
            ch = input.next().charAt(0);
            if (ch == 'Y') {
                clearConsole();
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("\033[1m|\t\t\t\tADD MARKS\t\t\t\t\t|\033[0m");
                System.out.println("--------------------------------------------------------------------------------");
                continue mainloop;
            }
            if (ch == 'n') {
                break mainloop;
            }
            while (ch != 'Y' && ch != 'n') {
                ch = input.next().charAt(0);
            }
        }
        return xr;
    }

    public static String[][] updateStudents(String[][] ar) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Student ID   : ");
            String key = input.next();
            int index = -1;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i][0].equals(key)) {
                    index = i;
                    System.out.println("Student Name : " + ar[i][1]);
                }
            }
            if (index < 0) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                break;
            } else {
                System.out.print("Enter the new student name : ");
                ar[index][1] = input.next();
                System.out.println("Student details has been updated successfully.");
                System.out.print("Do you want to update another student details? (Y/n) ");
                break;
            }
        }
        return ar;
    }

    public static int[][] updateMarks(String[][] ar, int[][] xr) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter Student ID   : ");
            String key = input.next();
            int index = -1;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i][0].equals(key)) {
                    index = i;
                    System.out.println("Student Name : " + ar[i][1]);
                    System.out.println();
                }
            }
            if (index < 0) {
                System.out.print("\nInvalid Student ID. Do you want to search again? (Y/n) ");
                break;
            } else if (xr[index][2] == 1) {
                System.out.println("This student's marks yet to be added.");
                System.out.print("Do you want to update marks for another student? (Y/n) ");
                break;
            } else {
                System.out.println("Programming Fundamentals Marks   : " + xr[index][0]);
                System.out.println("Database Management System Marks : " + xr[index][1]);
                System.out.println();
                System.out.print("Enter new Programming Fundamentals Marks   : ");
                xr[index][0] = input.nextInt();

                while (xr[index][0] > 100 || xr[index][0] < 0) {
                    System.out.println("Invalid marks, please enter correct marks.");
                    System.out.println();
                    System.out.print("Programming Fundamentals Marks   : ");
                    xr[index][0] = input.nextInt();
                }
                System.out.print("Enter new Database Management System Marks : ");
                xr[index][1] = input.nextInt();

                while (xr[index][1] > 100 || xr[index][1] < 0) {
                    System.out.println("Invalid marks, please enter correct marks.");
                    System.out.println();
                    System.out.print("Database Management System Marks : ");
                    xr[index][1] = input.nextInt();
                }
                System.out.println("\nMarks been updated successfully.");
                System.out.print("Do you want to update marks for another student? (Y/n) ");
                break;
            }
        }
        return xr;
    }

    public static String[][] deleteStudents(String[][] ar, int index) {
        Scanner input = new Scanner(System.in);
        int x = 0;
        String[][] temp = new String[ar.length - 1][2];

        for (int i = 0; i < ar.length; i++) {
            if (i == index) {
                continue;
            }
            temp[x] = ar[i];
            x++;
        }
        return temp;
    }

    public static int[][] deleteMarks(String[][] ar, int[][] xr, int index) {
        Scanner input = new Scanner(System.in);

        int x = 0;
        int[][] temp = new int[xr.length - 1][3];

        for (int i = 0; i < xr.length; i++) {
            if (i == index) {
                continue;
            }
            temp[x] = xr[i];
            x++;
        }
        System.out.println("Student has been deleted successfully.");
        System.out.print("Do you want to delete another student? (Y/n) ");

        return temp;
    }

    public static void printStudent(String[][] ar, int[][] xr) {
        Scanner input = new Scanner(System.in);
        char ch = 'Y';

        while (ch == 'Y') {
            System.out.print("Enter Student ID   : ");
            String key = input.next();
            int index = -1;
            for (int i = 0; i < ar.length; i++) {
                if (ar[i][0].equals(key)) {
                    index = i;
                    System.out.println("Student Name : " + ar[i][1]);
                    System.out.println();
                }
            }
            if (index < 0) {
                System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                break;
            } else {
                if (xr[index][2] == 1) {
                    System.out.println();
                    System.out.println("This student's marks yet to be added.");
                    System.out.print("Do you want to search another student details? (Y/n) ");
                    break;
                }
                int[] total = findTotal(xr);
                double avg = (double) total[index] / 2;
                int count = 0;
                for (int i = 0; i < total.length; i++) {
                    if (xr[i][2] == 0) {
                        count++;
                    }
                }
                int[] rank = new int[count];
                int a = 0;
                for (int j = 0; j < total.length; j++) {
                    if (a != rank.length) {
                        if (xr[j][2] == 0) {
                            rank[a] = total[j];
                            a++;
                        }
                    }
                }
                for (int i = rank.length - 1; i > 0; i--) {
                    for (int j = 0; j < i; j++) {
                        if (rank[j] < rank[j + 1]) {
                            int t = rank[j];
                            rank[j] = rank[j + 1];
                            rank[j + 1] = t;
                        }
                    }
                }
                int x = 0;
                for (int i = 0; i < rank.length; i++) {
                    if (total[index] == rank[i]) {
                        x = i;
                    }
                }
                a = x + 1;
                String s = "";
                if (x > 0 && rank[x - 1] == rank[x]) {
                    a = x;
                    if (a == rank.length - 1) {
                        s = " (Last)";
                    }
                }
                if (a == 1) {
                    s = " (First)";
                } else if (a == 2) {
                    s = " (Second)";
                } else if (a == 3) {
                    s = " (Third)";
                } else if (a == rank.length) {
                    s = " (Last)";
                }
                System.out.println("+------------------------------------+---------------+");
                System.out.printf("|Programming Fundamentals Marks      |%15s", xr[index][0]);
                System.out.printf("|\n");
                System.out.printf("|Database Management System Marks    |%15s", xr[index][1]);
                System.out.printf("|\n");
                System.out.printf("|Total  Marks                        |%15s", total[index]);
                System.out.printf("|\n");
                System.out.printf("|Avg. Marks                          |%15s", avg);
                System.out.printf("|\n");
                System.out.printf("|Rank                                |%15s", a + s);
                System.out.printf("|\n");
                System.out.printf("+------------------------------------+---------------+");
                System.out.println();
                System.out.print("Do you want to print details of another student? (Y/n) ");
                break;
            }
        }
    }

    public static int[] findTotal(int[][] xr) {
        int[] total = new int[xr.length];
        for (int i = 0; i < total.length; i++) {
            total[i] = xr[i][0] + xr[i][1];
        }
        return total;
    }

    public static void printRanks(String[][] ar, int[][] marks) {
        int[] total = findTotal(marks);
        int count = 0;
        for (int i = 0; i < total.length; i++) {
            if (marks[i][2] == 0) {
                count++;
            }
        }
        int[] rank = new int[count];
        int a = 0;
        for (int j = 0; j < total.length; j++) {
            if (a != rank.length) {
                if (marks[j][2] == 0) {
                    rank[a] = total[j];
                    a++;
                }
            }
        }
        for (int i = rank.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rank[j] < rank[j + 1]) {
                    int t = rank[j];
                    rank[j] = rank[j + 1];
                    rank[j + 1] = t;
                }
            }
        }
        int x = 0;
        System.out.println();
        System.out.printf("+----------+----------+--------------------+---------------+---------------+\n");
        System.out.printf("|%-10s", "Rank");
        System.out.printf("|%-10s", "ID");
        System.out.printf("|%-20s", "Name");
        System.out.printf("|%15s", "Total Marks");
        System.out.printf("|%15s", "Avg. Marks");
        System.out.printf("|\n");
        System.out.print("+----------+----------+--------------------+---------------+---------------+\n");

        while (x != rank.length) {
            int y = 0;
            while (x != rank.length && y != total.length) {
                if (rank[x] == total[y]) {
                    a = x + 1;
                    if (x > 0 && rank[x - 1] == rank[x]) {
                        a = x;
                    }
                    System.out.printf("|%-10s", a);
                    System.out.printf("|%-10s", ar[y][0]);
                    System.out.printf("|%-20s", ar[y][1]);
                    System.out.printf("|%15s", total[y]);
                    System.out.printf("|%15s", (double) total[y] / 2);
                    System.out.printf("|\n");
                    x++;
                }
                y++;
            }
        }
        System.out.printf("+----------+----------+--------------------+---------------+---------------+\n");
        System.out.print("Do you want to go back main menu? (Y) ");
    }

    public static void printBestInSubs(String[][] ar, int[][] marks, int id) {
        int count = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i][2] == 0) {
                count++;
            }
        }

        int[] rank = new int[count];
        int a = 0;
        for (int j = 0; j < marks.length; j++) {
            if (a != rank.length) {
                if (marks[j][2] == 0) {
                    rank[a] = marks[j][id];
                    a++;
                }
            }
        }
        for (int i = rank.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (rank[j] < rank[j + 1]) {
                    int t = rank[j];
                    rank[j] = rank[j + 1];
                    rank[j + 1] = t;
                }
            }
        }
        String s1 = "DBMS Marks", s2 = "PF Marks";
        int b = 0;
        a = 1;
        if (id == 0) {
            a = 0;
            b = 1;
            s1 = "PF Marks";
            s2 = "DBMS Marks";
        }
        int x = 0;
        System.out.println();
        System.out.println("+----------+--------------------+---------------+---------------+");
        System.out.printf("|%-10s", "ID");
        System.out.printf("|%-20s", "Name");
        System.out.printf("|%-15s", s1);
        System.out.printf("|%-15s", s2);
        System.out.printf("|\n");
        System.out.println("+----------+--------------------+---------------+---------------+");

        while (x != rank.length) {
            int y = 0;
            while (x != rank.length && y != marks.length) {
                if (rank[x] == marks[y][id]) {
                    System.out.printf("|%-10s", ar[y][0]);
                    System.out.printf("|%-20s", ar[y][1]);
                    System.out.printf("|%-15s", marks[y][a]);
                    System.out.printf("|%-15s", marks[y][b]);
                    System.out.printf("|\n");
                    x++;
                }
                y++;
            }
        }
        System.out.println("+----------+--------------------+---------------+---------------+");
        System.out.print("Do you want to go back main menu? (Y) ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mainMenu();
        System.out.print("\033[1mEnter an option to continue > \033[0m");
        int opt = input.nextInt();

        int[][] marks = new int[0][3];
        String[][] students = new String[0][2];
        while (true) {
            switch (opt) {
                //Add new student
                case 1:
                    char ch = 'Y';

                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tADD NEW STUDENT\t\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        students = addStudents(students);
                        marks = setValue(marks);
                        System.out.println();
                        System.out.print("Student has been added succesfully. Do you want to add a new student (Y/n): ");
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Add new students with marks
                case 2:
                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\tADD NEW STUDENT WITH MARKS\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        students = addStudents(students);
                        marks = addMarks(marks);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Add marks
                case 3:
                    clearConsole();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\033[1m|\t\t\t\tADD MARKS\t\t\t\t\t|\033[0m");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println();
                    marks = addOnlyMarks(students, marks);
                    clearConsole();
                    mainMenu();
                    System.out.print("\033[1mEnter an option to continue > \033[0m");
                    opt = input.nextInt();
                    break;

                //Update students details
                case 4:
                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tUPDATE STUDENT DETAILS\t\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        students = updateStudents(students);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Update marks
                case 5:
                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tUPDATE MARKS\t\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        marks = updateMarks(students, marks);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Delete student
                case 6:
                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tDELETE STUDENT\t\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.print("Enter Student ID   : ");
                        String key = input.next();
                        int index = -1;

                        for (int i = 0; i < students.length; i++) {
                            if (students[i][0].equals(key)) {
                                index = i;
                            }
                        }
                        if (index < 0) {
                            System.out.print("Invalid Student ID. Do you want to search again? (Y/n) ");
                            ch = input.next().charAt(0);
                            if (ch == 'Y') {
                                continue;
                            }
                            if (ch == 'n') {
                                break;
                            }
                        }
                        students = deleteStudents(students, index);
                        marks = deleteMarks(students, marks, index);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;


                //Print student details
                case 7:
                    do {
                        clearConsole();
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println("\033[1m|\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t|\033[0m");
                        System.out.println("--------------------------------------------------------------------------------");
                        System.out.println();
                        printStudent(students, marks);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'Y');
                    if (ch == 'n') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Print students' ranks
                case 8:
                    ch = 'n';
                    clearConsole();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\033[1m|\t\t\t\tPRINT STUDENTS' RANKS\t\t\t\t|\033[0m");
                    System.out.println("--------------------------------------------------------------------------------");
                    do {
                        printRanks(students, marks);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'n');
                    if (ch == 'Y') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Best in prf
                case 9:
                    clearConsole();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\033[1m|\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t\t|\033[0m");
                    System.out.println("--------------------------------------------------------------------------------");
                    do {
                        printBestInSubs(students, marks, 0);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'n');
                    if (ch == 'Y') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                //Best in dbms
                case 10:
                    clearConsole();
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("\033[1m|\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t|\033[0m");
                    System.out.println("--------------------------------------------------------------------------------");
                    do {
                        printBestInSubs(students, marks, 1);
                        ch = input.next().charAt(0);

                        while (ch != 'Y' && ch != 'n') {
                            ch = input.next().charAt(0);
                        }
                    } while (ch == 'n');
                    if (ch == 'Y') {
                        clearConsole();
                        mainMenu();
                        System.out.print("\033[1mEnter an option to continue > \033[0m");
                        opt = input.nextInt();
                    }
                    break;

                default:
                    System.out.println("Invalid Operation ! ...");
                    System.out.print("Try agin ...    : ");
                    opt = input.nextInt();
            }
        }
    }

}
