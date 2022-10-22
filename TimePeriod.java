public class TimePeriod{
/**
 *A TimePeriod is a Duration range. It has an inclusive lower bound, l, and an exclusive upper bound, u.
 *A Duration, d, falls within the range if l<=d<u.
 *@author Tamsanqa Thwala
 */
 
 private Duration lowerBound;
 private Duration upperBound;
 
 public TimePeriod(Duration lowerBound, Duration upperBound){
     this.lowerBound = lowerBound;
     this.upperBound = upperBound;
 }
 
  /**
  *get a lowerbound of time period
  */
  
 public Duration lowerBound(){
    return new Duration(lowerBound);
 }

 /**
  *get upperbound of time period
 */
 public Duration upperBound(){
     return new Duration(upperBound);
 }
 
 /**
  *determine whether this time falls within the timeperiod
  */
 public boolean includes(Duration duration){
     if (duration.compareTo(lowerBound) >= 0 && duration.compareTo(upperBound) < 0)
        return true;
     else
        return false;
 }
 
  /**
  *Determine whether this time period precedes the other time period
  */
 public boolean precedes(TimePeriod other){
     if (this.upperBound().compareTo(other.lowerBound()) <= 0)
        return true;
     else
         return false;
 }
 
 /**
  *determine whether a time period is adjacent to another
  */
 public boolean adjacent(TimePeriod other){
     if (this.lowerBound().compareTo(other.upperBound()) == 0 || this.upperBound().compareTo(other.lowerBound()) == 0)
        return true;
     else
         return false;
 }
 
 /**
  *Obtain a String representation of this TimePeriod object in the form:
  *"[<duration> .. <duration>]".
  */
 public String toString(){
     return '[' +Duration.format(lowerBound(),"minute") + " .. " + Duration.format(upperBound(),"minute") + ']' ;
 }
}   
