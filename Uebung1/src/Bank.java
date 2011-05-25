/**
 * Ein Objekt der Klasse Bank repräsentiert ein Bankinstitut.
 */
public class Bank extends AccountHolder {
  //@ public invariant 0 <= openCredits && openCredits <= max_credits;
  //@ public invariant 0 <= max_credits;
  
  /** Anzahl maximal vergebener Kredite */
  public int max_credits;
  /** Anzahl offener Kredite */
  public int openCredits;
  
  //@ requires limit <= 0;
  //@ requires max_credits >= 0;
  //@ ensures this.limit == limit;
  //@ ensures total == 0;
  //@ ensures openCredits == 0;
  public Bank(int limit, int max_credits) {
    super(limit);
    this.max_credits = max_credits;
    openCredits = 0;
  }
}
