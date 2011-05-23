/**
 * Accountbesitzer
 *
 */
public class AccountHolder {
  //@ invariant total >= limit;
  /**
   * Total
   * Gesamtbetrag auf allen Konten
   * */
  int total;
  
  /** †berziehungslimit */
  int limit;

  /**
   * Konstruktor
   * @param limit: Geldbetrag, den man maximal Ÿberziehen kann.
   */
  //@ requires limit <= 0;
  //@ ensures this.limit == limit;
  public AccountHolder(int limit){
    total = 0;
	  this.limit = limit;
  }
}
