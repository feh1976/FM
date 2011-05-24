public class Bank extends AccountHolder {
  
  /** Offene Kredite */
  int openCredits;
  
  //@ ensures openCredits == 0;
  public Bank() {
    super(Integer.MIN_VALUE); 
    openCredits = 0;
  }
}
