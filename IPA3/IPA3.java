
import java.util.Scanner;

public class IPA3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Student[] student = new Student[4];
    for (int i = 0; i < 4; i++) {
      int rollNo = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      String branch = sc.nextLine();
      double score = sc.nextDouble();
      sc.nextLine();
      boolean dayScholar = sc.nextBoolean();

      student[i] = new Student(rollNo, name, branch, score, dayScholar);
    }
    sc.close();
    int count = findCountOfDayScholarStudent(student);
    if (count == 0) {
      System.out.println("There are no such dayscholar students");
    } else {
      System.out.println(count);
    }

    Student result = findStudentWithSecondHighestScore(student);
    if (result == null) {
      System.out.println("There are no such student from non dayscholar");
    } else {
      System.out.println(result.getRollNo() + "#" + result.getName() + "#" + result.getScore());
    }
  }

  public static int findCountOfDayScholarStudent(Student[] student) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      if (student[i].getScore() > 80 && student[i].isDayScholar()) {
        count++;
      }
    }
    return count;
  }

  public static Student findStudentWithSecondHighestScore(Student[] student) {
    Student result = null;
    double max = 0, max1 = 0;
    for (int i = 0; i < 4; i++) {
      if (!student[i].isDayScholar()) {
        if (student[i].getScore() > max) {
          max = student[i].getScore();
          result = student[i];
        }
      }
    }
    for (int i = 0; i < 4; i++) {
      if (!student[i].isDayScholar()) {
        if (student[i].getScore() < max && student[i].getScore() > max1) {
          max1 = student[i].getScore();
          result = student[i];
        }
      }
    }
    return result;
  }
}

class Student {
  private int rollNo;
  private String name;
  private String branch;
  private double score;
  private boolean dayScholar;

  public Student(int rollNo, String name, String branch, double score, boolean dayScholar) {
    this.rollNo = rollNo;
    this.name = name;
    this.branch = branch;
    this.score = score;
    this.dayScholar = dayScholar;
  }

  public int getRollNo() {
    return rollNo;
  }

  public void setRollNo(int rollNo) {
    this.rollNo = rollNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  public boolean isDayScholar() {
    return dayScholar;
  }

  public void setDayScholar(boolean dayScholar) {
    this.dayScholar = dayScholar;
  }
}
