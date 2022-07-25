package classscheduler;

public class Database {
  private Class[] availableClasses;
  private boolean[] availabilityMirror;
  
  public Database(int numberOfClasses) {
    this.availableClasses = new Class[numberOfClasses];
    this.availabilityMirror = new boolean[numberOfClasses];
    for(int i = 0; i < numberOfClasses; i++) {
      availabilityMirror[i] = true;
    }
  }

  public void addClass(int classID, int classBlock, String className, String classTeacher) {
    this.availableClasses[classID] = new Class(classBlock, className, classTeacher);
  }

  public Class getClass(int id) {
    return this.availableClasses[id];
  }

  public void useClass(int ID) {
    this.availabilityMirror[ID] = false;
  }

  public void returnClassToDatabase(int ecksDee) {
    this.availabilityMirror[ecksDee] = true;
  }

  public void print() {
    for(int j = 0; j < this.availableClasses.length; j++) {
      if(this.availabilityMirror[j]) {
        System.out.println("ID: " + j + this.availableClasses[j]);
      }
    }
  }

}
