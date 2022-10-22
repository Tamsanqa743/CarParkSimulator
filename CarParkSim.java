import java.util.Scanner;
/**
 * The CarParkSim class contains the main car park simulation method.
 * It creates and manipulates the main objects, and handles user I/O.
 *
 * @author Stephan Jamieson and Tamsanqa Thwala
 * @version 19/09/2020
 */
public class CarParkSim {
        
    public static void main(final String[] args) {
        final Scanner keyboard = new Scanner(System.in);
        
        // Declare variables to store a Clock, TariffTable and a Register object, create the relevant objects and assign them. 
        Register register;
        Clock clock;
        TariffTable table;
        
        register = new Register();
        Time currentTime = new Time("00:00");
        clock = new Clock(currentTime);
        table = new TariffTable(10);
        final Currency currency = new Currency("R", "ZAR", 100);
        
        //populate the tariff table with tariffs.
        table.addTariff(new TimePeriod(new Duration("minute",0), new Duration("minute",30)), new Money("R10", currency));
        table.addTariff(new TimePeriod(new Duration("minute",30),new Duration("hour",1)), new Money("R15", currency));
        table.addTariff(new TimePeriod(new Duration("hour",1),new Duration("hour",3)), new Money("R20", currency));
        table.addTariff(new TimePeriod(new Duration("hour",3),new Duration("hour",4)), new Money("R30", currency));
        table.addTariff(new TimePeriod(new Duration("hour",4),new Duration("hour",5)), new Money("R40", currency));
        table.addTariff(new TimePeriod(new Duration("hour",5),new Duration("hour",6)), new Money("R50", currency));
        table.addTariff(new TimePeriod(new Duration("hour",6),new Duration("hour",8)), new Money("R60", currency));
        table.addTariff(new TimePeriod(new Duration("hour",8),new Duration("hour",10)), new Money("R70", currency));
        table.addTariff(new TimePeriod(new Duration("hour",10),new Duration("hour",12)), new Money("R90", currency));
        table.addTariff(new TimePeriod(new Duration("hour",12),new Duration("day",1)), new Money("R100", currency));


        
        System.out.println("Car Park Simulator");
        // Print current time.
        System.out.println("The current time is " + currentTime.toString()+".");
        
        System.out.println("Commands: tariffs, advance {minutes}, arrive, depart, quit.");
        System.out.print(">");
        String input = keyboard.next().toLowerCase();
        while (!input.equals("quit")) {
            if (input.equals("tariffs")){
                System.out.println(table.toString());
            }
            else if (input.equals("advance")) {
                 // Advance the clock, print the current time.
                input = keyboard.next();
                clock.advance(new Duration("minute",Integer.parseInt(input)));
                System.out.println("The current time is " + clock.examine().toString()+".");
            }
            else if (input.equals("arrive")) {
                // Create a new ticket, add it to the register, print details of ticket issued.
                String UID_One = UIDGenerator.makeUID();
                Ticket newTicket = new Ticket(clock.examine(),UID_One);
                register.add(newTicket);
                System.out.println("Ticket issued: " + newTicket.toString()+".");
            }
            else if (input.equals("depart")) {
                // Determine if ticket is valid, i.e. in the register.
                // If not, print error message.
                // If yes, retreive it, calculate duration of stay and print it.
                System.out.println("Enter ticket ID");
                System.out.print(">");
               input = keyboard.next();
               Duration duration;
               long hour;
               double minutes;
               if (register.contains(input)){
                   System.out.println("Ticket details: " + register.retrieve(input)+".");
                   System.out.println("Current time: " + clock.examine()+".");
                   
                   //caluclate and return the duration of stay for a given ticket ID 
                   duration = register.retrieve(input).age( clock.examine());
                   System.out.printf("Duration of stay: %s.\n", Duration.format(duration, "minute"));

                   //retrieve and print the cost of stay for the duration stayed.
                   System.out.println("Cost of stay : "+ table.getTariff(duration) +"."); 
               }
              else
                   System.out.println("Invalid ticket ID.");
            }
            else {
                System.out.println("That command is not recognised.");
                System.out.println("Commands: tariffs, advance <minutes>, arrive, depart, quit.");
            }            
            System.out.print(">");
            input = keyboard.next().toLowerCase();
        }            
        System.out.println("Goodbye.");
    }

}
