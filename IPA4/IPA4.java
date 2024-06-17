package IPA4;

import java.util.*;

public class IPA4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    College[] college = new College[n];
    for (int i = 0; i < n; i++) {
      int id = sc.nextInt();
      sc.nextLine();
      String name = sc.nextLine();
      int cont = sc.nextInt();
      sc.nextLine();
      String add = sc.nextLine();
      int pin = sc.nextInt();
      sc.nextLine();

      college[i] = new College(id, name, cont, add, pin);
    }
    String input = sc.nextLine();
    sc.close();

    College result = findCollegeWithMaxPin(college);
    if (result == null) {
      System.out.println("No college found with mentioned attribute");
      System.out.println();
    } else {
      System.out.println("id-" + result.getId());
      System.out.println();
      System.out.println("name-" + result.getName());
      System.out.println();
      System.out.println("contactNo-" + result.getCont());
      System.out.println();
      System.out.println("address-" + result.getAdd());
      System.out.println();
      System.out.println("pincode-" + result.getPin());
      System.out.println();
    }

    College output = searchClgByAdd(college, input);
    if (output == null) {
      System.out.println("No college found with mentioned attribute");
      System.out.println();
    } else {
      System.out.println("id-" + output.getId());
      System.out.println();
      System.out.println("name-" + output.getName());
      System.out.println();
      System.out.println("contactNo-" + output.getCont());
      System.out.println();
      System.out.println("address-" + output.getAdd());
      System.out.println();
      System.out.println("pincode-" + output.getPin());
      System.out.println();
    }
  }

  public static College findCollegeWithMaxPin(College[] college) {
    College result = null;
    int max = 0;
    for (int i = 0; i < college.length; i++) {
      if (college[i].getPin() > max) {
        max = college[i].getPin();
        result = college[i];
      }
    }
    return result;
  }

  public static College searchClgByAdd(College[] college, String input) {
    for (int i = 0; i < college.length; i++) {
      if (input.equalsIgnoreCase(college[i].getAdd())) {
        return college[i];
      }
    }
    return null;
  }
}

class College {
  private int id;
  private String name;
  private int cont;
  private String add;
  private int pin;

  public College(int id, String name, int cont, String add, int pin) {
    this.id = id;
    this.name = name;
    this.cont = cont;
    this.add = add;
    this.pin = pin;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public int getCont() {
    return cont;
  }

  public void setCont(int cont) {
    this.cont = cont;
  }

  public String getAdd() {
    return add;
  }

  public void setAdd(String add) {
    this.add = add;
  }

  public int getPin() {
    return pin;
  }

  public void setPin(int pin) {
    this.pin = pin;
  }
}