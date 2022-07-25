package classscheduler;

public class Class {
  private int block;
  private String className;
  private String teacher;
  
  public Class(int block, String name, String teacher) {
    this.block = block;
    this.className = name;
    this.teacher = teacher;
  }

  public int getBlock() {
    return this.block;
  }

  public String getName() {
    return this.className;
  }

  public String toString() {
    return (", Block: " + this.block + ", Name: " + this.className + ", Teacher: " + this.teacher);
  }
  
}