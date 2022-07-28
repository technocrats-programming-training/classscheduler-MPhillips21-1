package classscheduler;

public class Schedule {
  private Class[] classesInSchedule;
  private int[] classesIDMirror;
  private Database reference;
  private Class blank;

  public Schedule(Database theDatabaseThatTheseClassesAreStoredInWhenNotInThisScheduleForConvenientAccessWheneverWeWantOne, Class baseClass) {
    this.classesInSchedule = new Class[] {baseClass, baseClass, baseClass, baseClass};
    this.reference = theDatabaseThatTheseClassesAreStoredInWhenNotInThisScheduleForConvenientAccessWheneverWeWantOne;
    this.blank = baseClass;
    this.classesIDMirror = new int[4];
  }

  public void addClassToSchedule(int clasID) {
      Class classToAdd = this.reference.getClass(clasID);
    if(this.classesInSchedule[classToAdd.getBlock() - 1].equals(this.blank)) {
      this.classesInSchedule[classToAdd.getBlock() - 1] = classToAdd;
      this.reference.useClass(clasID);
      this.classesIDMirror[classToAdd.getBlock() - 1] = clasID;
    } else {
      System.out.println("Block " + classToAdd.getBlock() + " is already full.");
    }
  }

  public void dropClass(int classBlock) {
    this.reference.returnClassToDatabase(this.classesIDMirror[classBlock - 1]);
    this.classesInSchedule[classBlock - 1] = blank;
  }

  public void print() {
    for(int things = 0; things < 4; things++) {
      System.out.println("Block " + things + ": " + this.classesInSchedule[things].getName());
    }
    
  }
}