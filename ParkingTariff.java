import java.util.Arrays;
public class ParkingTariff{

/**
 *a parking tariff stores a time period and money.
 *
 *
 *@Author Tamsanqa Thwala
 *@version 19/09/2020
 */

 private TimePeriod period;
 private Money tariff;
 
/**
 *create a new parking tariff with a period and money
 *
 */
 public ParkingTariff(TimePeriod period, Money tariff){
     this.period = period;
     this.tariff = tariff;
 } 
 
 /**
  *get the time period of a parking tariff.
  */
  public TimePeriod getPeriod(){
      return period;
  }
  
  /**
   *get the cost of a given parking tariff.
   */
   
  public Money getTariff(){
      return tariff;
  }
  
  /**
   *set the time period to a parking tariff
   */
  public void setPeriod(TimePeriod newPeriod){
      period = newPeriod;
  }
  
 /**
  *set a new cost for a parking tariff
  */
  
 public void setTariff(Money newTariff){
     tariff = newTariff;
 }
 /**
  *string representation of the parking tariff
  *in the format:
  *<period0> : <tariff0>
  */
  public String toString(){
      return period.toString()+" : "+tariff;
  } 
}