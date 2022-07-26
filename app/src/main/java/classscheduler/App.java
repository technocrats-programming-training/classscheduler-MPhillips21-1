package classscheduler;

import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
  public static void main(String[] args) {
    Scanner yma = new Scanner(System.in);
    System.out.println("How many classes would you like to add?");
    int numberOfClasses = yma.nextInt();
    yma.nextLine();
    Database classes = new Database(numberOfClasses);
    int cci = 0;
    int blockOfClass;
    String nameOfClass;
    String teacherOfClass;
    int chosenID;
    int chosenBlock;

    while (cci < numberOfClasses) {
      System.out.println("\n" + "Block: ");
      try {
        blockOfClass = yma.nextInt();
        yma.nextLine();
      } catch (InputMismatchException notAnInt) {
        System.out.println("\n" + "This should be an integer.");
        yma.nextLine();
        continue;
      }
      System.out.println("\n" + "Name:");
      nameOfClass = yma.nextLine();
      System.out.println("\n" + "Teacher: ");
      teacherOfClass = yma.nextLine();

      classes.addClass(cci, blockOfClass, nameOfClass, teacherOfClass);
      cci++;
    }

    Schedule schedule = new Schedule(classes, new Class(0, "empty", "none"));

    while (true) {
      System.out.println("\n" + "Enter a command (add, drop, viewSchedule, viewAvailable): ");
      switch (yma.nextLine()) {
        case "add":
          System.out.println("\n" + "Enter Class ID: ");
          try {
            chosenID = yma.nextInt();
            yma.nextLine();
          } catch (InputMismatchException bad) {
            System.out.println("\n" + "Not a valid ID");
            yma.nextLine();
            break;
          }
          if ((chosenID > -1) && (chosenID < numberOfClasses)) {
            schedule.addClassToSchedule(chosenID);
          } else {
            System.out.println("\n" + "Not a valid ID");
            yma.nextLine();
            break;
          }
          break;

        case "drop":
          System.out.println("\n" + "Enter block: ");
          try {
            chosenBlock = yma.nextInt();
            yma.nextLine();
          } catch (InputMismatchException bad) {
            System.out.println("\n" + "Not a valid block");
            yma.nextLine();
            break;
          }
          if ((chosenBlock > 0) && (chosenBlock < 5)) {
            schedule.dropClass(chosenBlock);
          } else {
            System.out.println("\n" + "Not a valid block");
            yma.nextLine();
            break;
          }
          break;

        case "viewSchedule":
          schedule.print();
          break;
        case "viewAvailable":
          classes.print();
          break;
        default:
          System.out.println("\n" + "Pick an option");
      }
    }

  }
}
