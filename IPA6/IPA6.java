package IPA6;

import java.util.Scanner;

public class IPA6 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    sc.nextLine();
    RRT[] rrt = new RRT[n];
    for (int i = 0; i < n; i++) {
      int ticketNo = sc.nextInt();
      sc.nextLine();
      String raisedBy = sc.nextLine();
      String assignedTo = sc.nextLine();
      int priority = sc.nextInt();
      sc.nextLine();
      String project = sc.nextLine();

      rrt[i] = new RRT(ticketNo, raisedBy, assignedTo, priority, project);
    }
    String input = sc.nextLine();
    sc.close();

    RRT result = getHighestPriorityTicket(rrt, input);
    if (result != null) {
      System.out.println(result.getTicketNo());
      System.out.println(result.getRaisedBy());
      System.out.println(result.getAssignedTo());
    } else {
      System.out.println("No Such Ticket");
    }
  }

  public static RRT getHighestPriorityTicket(RRT[] rrt, String input) {
    RRT result = null;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < rrt.length; i++) {
      if (input.equalsIgnoreCase(rrt[i].getProject())) {
        if (rrt[i].getPriority() < min) {
          min = rrt[i].getPriority();
          result = rrt[i];
        }
      }
    }
    return result;
  }
}

class RRT {
  private int ticketNo;
  private String raisedBy;
  private String assignedTo;
  private int priority;
  private String project;

  public RRT(int ticketNo, String raisedBy, String assignedTo, int priority, String project) {
    this.ticketNo = ticketNo;
    this.raisedBy = raisedBy;
    this.assignedTo = assignedTo;
    this.priority = priority;
    this.project = project;
  }

  public int getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(int ticketNo) {
    this.ticketNo = ticketNo;
  }

  public String getRaisedBy() {
    return raisedBy;
  }

  public void setRaisedBy(String raisedBy) {
    this.raisedBy = raisedBy;
  }

  public String getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(String assignedTo) {
    this.assignedTo = assignedTo;
  }

  public int getPriority() {
    return priority;
  }

  public void setPriority(int priority) {
    this.priority = priority;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }
}