package IPA11;

import java.util.*;

public class IPA11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Player[] player = new Player[4];
    for (int i = 0; i < 4; i++) {
      int playerId = sc.nextInt();
      sc.nextLine();
      String skill = sc.nextLine();
      String level = sc.nextLine();
      int points = sc.nextInt();
      sc.nextLine();

      player[i] = new Player(playerId, skill, level, points);
    }
    String inputSkill = sc.nextLine();
    String inputLevel = sc.nextLine();
    sc.close();

    int countOfPoints = findPointsForGivenSkill(player, inputSkill);
    if (countOfPoints == 0)
      System.out.println("The given Skill is not available");
    else
      System.out.println(countOfPoints);

    Player result = getPlayerBasedOnLevel(player, inputSkill, inputLevel);
    if (result == null) {
      System.out.println("No player is available with specified level skill and eligibity points");
    } else {
      System.out.println(result.getPlayerId());
    }
  }

  public static int findPointsForGivenSkill(Player[] player, String inputSkill) {
    int count = 0;
    for (int i = 0; i < 4; i++) {
      if (player[i].getSkill().equalsIgnoreCase(inputSkill)) {
        count += player[i].getPoints();
      }
    }
    return count;
  }

  public static Player getPlayerBasedOnLevel(Player[] player, String inputSkill, String inputLevel) {
    Player result = null;
    for (int i = 0; i < 4; i++) {
      if (player[i].getPoints() >= 20) {
        if (player[i].getSkill().equalsIgnoreCase(inputSkill) && player[i].getLevel().equalsIgnoreCase(inputLevel)) {
          return player[i];
        }
      }
    }
    return result;
  }
}

class Player {
  int playerId;
  String skill;
  String level;
  int points;

  public Player(int playerId, String skill, String level, int points) {
    this.playerId = playerId;
    this.skill = skill;
    this.level = level;
    this.points = points;
  }

  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public String getSkill() {
    return skill;
  }

  public void setSkill(String skill) {
    this.skill = skill;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
