package IPA15;

import java.util.*;

public class IPA15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Phone[] phone = new Phone[4];
    for (int i = 0; i < 4; i++) {
      int phoneId = sc.nextInt();
      sc.nextLine();
      String os = sc.nextLine();
      String brand = sc.nextLine();
      int price = sc.nextInt();
      sc.nextLine();

      phone[i] = new Phone(phoneId, os, brand, price);
    }
    String inputBrand = sc.nextLine();
    String inputOs = sc.nextLine();
    sc.close();
    int totalPrice = findPriceForGivenBrand(phone, inputBrand);
    if (totalPrice == 0) {
      System.out.println("The given brand is not available");
    } else {
      System.out.println(totalPrice);
    }
    Phone[] result = getPhoneIdBasedOnOs(phone, inputOs);
    if (result.length == 0) {
      System.out.println("No phones are available with specified os and price range");
    } else {
      for (int i = 0; i < result.length; i++) {
        System.out.println(result[i].getPhoneId());
      }
    }
  }

  public static int findPriceForGivenBrand(Phone[] phone, String inputBrand) {
    int countPrice = 0;
    for (int i = 0; i < 4; i++) {
      if (phone[i].getBrand().equalsIgnoreCase(inputBrand)) {
        countPrice = phone[i].getPrice();
      }
    }
    return countPrice;
  }

  public static Phone[] getPhoneIdBasedOnOs(Phone[] phone, String inputOs) {
    Phone[] result = new Phone[0];
    for (int i = 0; i < 4; i++) {
      if (phone[i].getOs().equalsIgnoreCase(inputOs)) {
        if (phone[i].getPrice() >= 50000) {
          result = Arrays.copyOf(result, result.length + 1);
          result[result.length - 1] = phone[i];
        }
      }
    }
    return result;
  }
}

class Phone {
  int phoneId;
  String os;
  String brand;
  int price;

  public Phone(int phoneId, String os, String brand, int price) {
    this.phoneId = phoneId;
    this.os = os;
    this.brand = brand;
    this.price = price;
  }

  public int getPhoneId() {
    return phoneId;
  }

  public void setPhoneId(int phoneId) {
    this.phoneId = phoneId;
  }

  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}