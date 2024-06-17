package IPA17;

import java.util.*;

public class IPA17 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Student[] student = new Student[4];
    for (int i = 0; i < 4; i++) {
      int rollNo = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      String subject = sc.nextLine();
      char grade = sc.nextLine().charAt(0);
      String date = sc.nextLine();

      student[i] = new Student(rollNo, name, subject, grade, date);
    }
    char inputGrade = sc.nextLine().charAt(0);
    int intValue = sc.nextInt();
    sc.nextLine();
    sc.close();

    Student[] result = findStudentByGradeAndMonth(student, inputGrade, intValue);
    if (result.length == 0) {
      System.out.println("No students found");
    } else {
      for (int i = 0; i < result.length; i++) {
        System.out.println(result[i].getName());
        System.out.println(result[i].getSubject());
      }
      System.out.println(result.length);
    }
  }

  public static Student[] findStudentByGradeAndMonth(Student[] student, char inputGrade, int intValue) {
    Student[] result = new Student[0];
    for (int i = 0; i < 4; i++) {
      if (student[i].getGrade() == inputGrade) {
        int month = Integer.parseInt(student[i].getDate().substring(3, 5));
        if (month == intValue) {
          result = Arrays.copyOf(result, result.length + 1);
          result[result.length - 1] = student[i];
        }
      }
    }
    for (int i = 0; i < result.length; i++) {
      for (int j = i + 1; j < result.length; j++) {
        if (result[i].getRollNo() > result[j].getRollNo()) {
          Student temp = result[i];
          result[i] = result[j];
          result[j] = temp;
        }
      }
    }
    return result;
  }
}

class Student {
  private int rollNo;
  private String name, subject, date;
  private char grade;

  public Student(int rollNo, String name, String subject, char grade, String date) {
    this.rollNo = rollNo;
    this.name = name;
    this.subject = subject;
    this.date = date;
    this.grade = grade;
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

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public char getGrade() {
    return grade;
  }

  public void setGrade(char grade) {
    this.grade = grade;
  }
}
