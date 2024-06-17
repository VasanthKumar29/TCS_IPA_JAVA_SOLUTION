package IPA10;

import java.util.*;

public class IPA10 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    sc.nextLine();
    Employee[] employee = new Employee[num];
    for (int i = 0; i < num; i++) {
      int employeeId = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      String branch = sc.nextLine();
      double rating = sc.nextDouble();
      sc.nextLine();
      boolean companyTransport = sc.nextBoolean();
      sc.nextLine();

      employee[i] = new Employee(employeeId, name, branch, rating, companyTransport);
    }
    String input = sc.nextLine();
    sc.close();

    int count = findCountOfEmployeeUsingComTransport(employee, input);
    if (count == 0)
      System.out.println("No such employees");
    else
      System.out.println(count);

    Employee result = findEmployeeWithSecondHighestRating(employee);
    if (result == null)
      System.out.println("All Employees using company transport");
    else {
      System.out.println(result.getEmployeeId());
      System.out.println(result.getName());
    }
  }

  public static int findCountOfEmployeeUsingComTransport(Employee[] employee, String input) {
    int count = 0;
    for (int i = 0; i < employee.length; i++) {
      if (employee[i].getBranch().equals(input)) {
        count += employee[i].isCompanyTransport() ? 1 : 0;
      }
    }
    return count;
  }

  public static Employee findEmployeeWithSecondHighestRating(Employee[] employee) {
    Employee[] arr = new Employee[0];
    Employee result = null;
    for (int i = 0; i < employee.length; i++) {
      if (employee[i].isCompanyTransport() == false) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = employee[i];
      }
    }
    if (arr.length < 2)
      return result;
    double max = 0, max2 = 0;
    for (int i = 0; i < arr.length; i++) {
      max = Math.max(max, arr[i].getRating());
    }
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getRating() > max2 && arr[i].getRating() < max) {
        max2 = arr[i].getRating();
        result = arr[i];
      }
    }
    return result;
  }
}

class Employee {
  private int employeeId;
  private String name;
  private String branch;
  private double rating;
  private boolean companyTransport;

  public Employee(int employeeId, String name, String branch, double rating, boolean companyTransport) {
    this.employeeId = employeeId;
    this.name = name;
    this.branch = branch;
    this.rating = rating;
    this.companyTransport = companyTransport;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
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

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public boolean isCompanyTransport() {
    return companyTransport;
  }

  public void setCompanyTransport(boolean companyTransport) {
    this.companyTransport = companyTransport;
  }

}
