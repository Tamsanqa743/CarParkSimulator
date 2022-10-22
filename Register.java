import java.util.Arrays;
public class Register{
    /**
     * stores a collection of Tickets
     * a Ticket may be retrieved given its ID
     **/
     
     private Ticket[] tickets;
     private int numTickets;
     
     /**
      * create a register object
      **/
      public Register(){
          tickets = new Ticket[100];
      }
      
      /**
       * Store the given ticket in the register
       **/
      public void add(Ticket ticket){
          tickets[numTickets] = ticket;
          numTickets++;
      }
      
      /**
       * Check if a ticket is in the register
       */
      
    public boolean contains(String ticketID){
        String result = "";
        for (int i=0; i< tickets.length; i++)
           if (tickets[i] != null)
               if (tickets[i].ID().equals(ticketID))
                   result = "true";
        return Boolean.parseBoolean(result);
    }
            
     /**
      * retrieve a ticket stored in register
      */
       
      public Ticket retrieve(String ticketID){
          String num = "";
          for (int i=0; i< tickets.length; i++)
              if (tickets[i] != null)
                 if (tickets[i].ID().equals(ticketID))
                      num = Integer.toString(i);      
       return tickets[Integer.parseInt(num)];
       }
     }
