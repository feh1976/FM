/**
 * Accountbesitzer
 */
public class AccountHolder {
  //@ invariant total >= limit;
  
  /** Gesamtbetrag auf allen Konten */
  int total;
  /** Überziehungslimit */
  int limit;

  /**
   * Konstruktor
   * @param limit: Geldbetrag, den man maximal überziehen kann.
   */
  //@ requires limit <= 0;
  //@ ensures total == 0;
  //@ ensures this.limit == limit;
  public AccountHolder(int limit){
    total = 0;
	  this.limit = limit;
  }
}
