import java.util.Arrays;
import java.util.Scanner;

public class IPA1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.nextLine();
    Course[] course = new Course[num];
    for (int i = 0; i < num; i++) {
      int courseId = sc.nextInt();
      sc.nextLine();
      String courseName = sc.nextLine();
      String courseAdmin = sc.nextLine();
      int quiz = sc.nextInt();
      sc.nextLine();
      int handson = sc.nextInt();
      sc.nextLine();

      course[i] = new Course(courseId, courseName, courseAdmin, quiz, handson);
    }
    String input1 = sc.nextLine();
    int input2 = sc.nextInt();
    sc.close();

    int average = findAvgOfQuizByAdmin(course, input1);
    if (average == 0)
      System.out.println("No Course Found");
    else
      System.out.println(average);

    Course[] result = sortCourseByHandson(course, input2);
    if (result == null)
      System.out.println("No Course found with mentioned attributes");
    else {
      for (int i = 0; i < result.length; i++) {
        System.out.println(result[i].getCourseName());
      }
    }
  }

  public static int findAvgOfQuizByAdmin(Course[] course, String input1) {
    int sum = 0, count = 0;
    for (int i = 0; i < course.length; i++) {
      if (course[i].getCourseAdmin().equalsIgnoreCase(input1)) {
        sum += course[i].getQuiz();
        count++;
      }
    }
    if (sum > 0)
      return sum / count;
    return 0;
  }

  public static Course[] sortCourseByHandson(Course[] course, int input2) {
    Course[] result = new Course[0];
    for (int i = 0; i < course.length; i++) {
      if (course[i].getHandson() < input2) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = course[i];
      }
    }
    if (result.length == 0)
      return null;
    for (int i = 0; i < result.length; i++) {
      for (int j = i + 1; j < result.length; j++) {
        if (result[i].getHandson() > result[j].getHandson()) {
          Course temp = result[i];
          result[i] = result[j];
          result[j] = temp;
        }
      }
    }
    return result;
  }
}

class Course {
  private int courseId;
  private String courseName;
  private String courseAdmin;
  private int quiz;
  private int handson;

  public Course(int courseId, String courseName, String courseAdmin, int quiz, int handson) {
    this.courseId = courseId;
    this.courseName = courseName;
    this.courseAdmin = courseAdmin;
    this.quiz = quiz;
    this.handson = handson;
  }

  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getCourseAdmin() {
    return courseAdmin;
  }

  public void setCourseAdmin(String courseAdmin) {
    this.courseAdmin = courseAdmin;
  }

  public int getQuiz() {
    return quiz;
  }

  public void setQuiz(int quiz) {
    this.quiz = quiz;
  }

  public int getHandson() {
    return handson;
  }

  public void setHandson(int handson) {
    this.handson = handson;
  }

}
