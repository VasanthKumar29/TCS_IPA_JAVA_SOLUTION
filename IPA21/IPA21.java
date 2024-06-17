package IPA21;

import java.util.Scanner;

public class IPA21 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Fruits[] fruits = new Fruits[4];
    for (int i = 0; i < 4; i++) {
      int fruitId = sc.nextInt();
      sc.nextLine();
      String fruitName = sc.nextLine();
      int price = sc.nextInt();
      sc.nextLine();
      int rating = sc.nextInt();
      sc.nextLine();

      fruits[i] = new Fruits(fruitId, fruitName, price, rating);
    }
    int inputRating = sc.nextInt();
    sc.nextLine();
    sc.close();
    Fruits result = findMaxPriceByRating(fruits, inputRating);
    if (result == null) {
      System.out.println("No such fruit");
    } else {
      System.out.println(result.getFruitId());
    }
  }

  public static Fruits findMaxPriceByRating(Fruits[] fruits, int inputRating) {
    Fruits result = null;
    int max = 0;
    for (int i = 0; i < 4; i++) {
      if (fruits[i].getRating() > inputRating) {
        if (fruits[i].getPrice() > max) {
          max = fruits[i].getPrice();
          result = fruits[i];
        }
      }
    }
    return result;
  }
}

class Fruits {
  private int fruitId;
  private String fruitName;
  private int price, rating;

  public Fruits(int fruitId, String fruitName, int price, int rating) {
    this.fruitId = fruitId;
    this.fruitName = fruitName;
    this.price = price;
    this.rating = rating;
  }

  public int getFruitId() {
    return fruitId;
  }

  public void setFruitId(int fruitId) {
    this.fruitId = fruitId;
  }

  public String getFruitName() {
    return fruitName;
  }

  public void setFruitName(String fruitName) {
    this.fruitName = fruitName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
