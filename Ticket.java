/**
 *A Ticket object represents a car park ticket. It has a unique ID and time of issue (24 hour clock).
 *@author Tamsanqa Thwala
 *@version 05/09/2020
 **/
 public class Ticket
 {
  private String id;
  private Time issueTime;
  
  /**
   * create a ticket object
   **/
  public Ticket(Time currentTime, String ID){
      issueTime = currentTime;
      id = ID;
  }
  
   /* get ticket id 
  */
  public String ID(){
      return id;
  }
  
  public Duration age(Time currentTime){
      return currentTime.subtract(issueTime);
  }
  
  /**Obtain a String representation of this ticket
   */ 
  public String toString(){
      return "Ticket[id="+ id +", time="+ issueTime +"]";
  }
  
  public boolean equals(Ticket otherTicket){
      if (this.id.equals(otherTicket.id))
         return true;
      return false;
  }
 }
