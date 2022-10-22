public class TariffTable{
/**
 *A TariffTable that records parking tariffs for a pay-to-stay car park.
 *
 *@author Tamsanqa Thwala
 *@version 19/09/2020
 */
 
 private int tableSize;
 private ParkingTariff[] table;
 private int numTariffs;
 
 /**
  *create a tariffTable with a specified maximum size.
  *@param maxSize takes an integer that specifies the size of tariff table
  */
 public TariffTable(int maxSize){
     table = new ParkingTariff[maxSize];
 }
     
 /**
  *add the tariff for the period to the table.
  *The tariff must follow exactly the time period after the previous tariff.
  *if the precondition is not met, an exception will be thrown
  */
 public void addTariff(TimePeriod period, Money tariff){
     ParkingTariff newTariff = new ParkingTariff(period, tariff);
     if (table[0] == null){
         table[0] = newTariff;
         numTariffs++;
     }
     else 
         if (table[numTariffs-1].getPeriod().adjacent(newTariff.getPeriod()) && table[numTariffs-1].getPeriod().precedes(newTariff.getPeriod()))
         {
             table[numTariffs] = newTariff;
             numTariffs++;
         } 
          else throw new IllegalArgumentException("Tariff periods must be adjacent.");    
     }
     
 /**
  *obtain the tariff money for the given length of stay as a duration.
  *@param lengthOfStay 
  */
  public Money getTariff(Duration lengthOfStay){
      int num=0;
      for (int i=0; i < table.length; i++)
          if (table[i] != null)
              if (table[i].getPeriod().includes(lengthOfStay))
                 num = i;
  return table[num].getTariff();
  }
 /**
  *Obtain a String representation of this TariffTable in the form:
  *<period> : <tariff>
  *<periodn> : <tariffn>
  */
 public String toString(){
     String stringTable = "";
     for (int j =0; j<table.length; j++){
         if (table[j] != null)
             stringTable = stringTable + table[j].getPeriod()+" : "+ table[j].getTariff()+"\n" ;
     }
    return stringTable.trim();
 }
}