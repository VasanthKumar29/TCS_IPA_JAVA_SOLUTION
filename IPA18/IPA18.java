package IPA18;

import java.util.*;

public class IPA18 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Antenna[] antenna = new Antenna[4];
    for (int i = 0; i < 4; i++) {
      int antennaId = sc.nextInt();
      sc.nextLine();
      String antennaName = sc.nextLine();
      String projectLead = sc.nextLine();
      double antennaVSWR = sc.nextDouble();
      sc.nextLine();

      antenna[i] = new Antenna(antennaId, antennaName, projectLead, antennaVSWR);
    }
    String inputName = sc.nextLine();
    double inputVSWR = sc.nextDouble();
    sc.close();
    int output = searchAntennaByName(antenna, inputName);
    if (output == 0) {
      System.out.println("There is no antenna with the given parameter");
    } else {
      System.out.println(output);
    }
    Antenna[] result = sortAntennaByVSWR(antenna, inputVSWR);
    if (result == null) {
      System.out.println("No Antenna found");
    } else {
      for (int i = 0; i < result.length; i++) {
        System.out.println(result[i].getProjectLead());
      }
    }
  }

  public static int searchAntennaByName(Antenna[] antenna, String inputName) {
    for (int i = 0; i < 4; i++) {
      if (antenna[i].getAntennaName().equalsIgnoreCase(inputName)) {
        return antenna[i].getAntennaId();
      }
    }
    return 0;
  }

  public static Antenna[] sortAntennaByVSWR(Antenna[] antenna, double inputVSWR) {
    Antenna[] result = new Antenna[0];
    for (int i = 0; i < 4; i++) {
      if (antenna[i].getAntennaVSWR() < inputVSWR) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = antenna[i];
      }
    }
    if (result.length == 0)
      return null;
    for (int i = 0; i < result.length; i++) {
      for (int j = i + 1; j < result.length; j++) {
        if (result[i].getAntennaVSWR() > result[j].getAntennaVSWR()) {
          Antenna temp = result[i];
          result[i] = result[j];
          result[j] = temp;
        }
      }
    }
    return result;
  }
}

class Antenna {
  private int antennaId;
  private String antennaName;
  private String projectLead;
  private double antennaVSWR;

  public Antenna(int antennaId, String antennaName, String projectLead, double antennaVSWR) {
    this.antennaId = antennaId;
    this.antennaName = antennaName;
    this.projectLead = projectLead;
    this.antennaVSWR = antennaVSWR;
  }

  public int getAntennaId() {
    return antennaId;
  }

  public void setAntennaId(int antennaId) {
    this.antennaId = antennaId;
  }

  public String getAntennaName() {
    return antennaName;
  }

  public void setAntennaName(String antennaName) {
    this.antennaName = antennaName;
  }

  public String getProjectLead() {
    return projectLead;
  }

  public void setProjectLead(String projectLead) {
    this.projectLead = projectLead;
  }

  public double getAntennaVSWR() {
    return antennaVSWR;
  }

  public void setAntennaVSWR(double antennaVSWR) {
    this.antennaVSWR = antennaVSWR;
  }

}
