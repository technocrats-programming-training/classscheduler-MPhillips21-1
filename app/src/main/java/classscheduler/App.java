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
        System.out.println("This should be an integer.");
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
      System.out.println("Enter a command (add, drop, viewSchedule, viewAvailable): ");
      yma.nextLine();
      switch (yma.nextLine()) {
        case "add":
          System.out.println("Enter Class ID: ");
          try {
            chosenID = yma.nextInt();
            yma.nextLine();
          } catch (InputMismatchException bad) {
            System.out.println("Not a valid ID");
            continue;
          }
          if ((chosenID > -1) && (chosenID < numberOfClasses)) {
            schedule.addClassToSchedule(chosenID);
          } else {
            System.out.println("Not a valid ID");
            continue;
          }
          break;

        case "drop":
          System.out.println("Enter block: ");
          try {
            chosenBlock = yma.nextInt();
            yma.nextLine();
          } catch (InputMismatchException bad) {
            System.out.println("Not a valid block");
            continue;
          }
          if ((chosenBlock > -1) && (chosenBlock < numberOfClasses)) {
            schedule.dropClass(chosenBlock);
          } else {
            System.out.println("Not a valid block");
            continue;
          }
          break;

        case "viewSchedule":
          schedule.print();
        case "viewAvailable":
          classes.print();
        default:
          System.out.println("Pick an option");
      }
    }

  }
}
