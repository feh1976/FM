public class Konto {
  /** Accountbesitzer */
  AccountHolder owner;
  
	/** Kontostand */
	int balance;
	
  //@ ensures balance == 0;     
	public Konto(){
	  balance = 0;
	}
	
	/**
	 * Erhšht den Kontostand.
	 * @param amount: Hšhe des Geldbetrages
	 */
	//@ requires amount >= 0;
	public void inc(int amount){
	  balance += amount;
	}

  /**
   * Senkt den Kontostand.
   * @param amount: Hšhe des Geldbetrages
   */
  //@ requires amount >= 0;
	public void dec(int amount){
    balance -= amount;
	}

	//@ ensures \result == balance;
	/*@pure*/ public int getBalance(){
	  return balance;
	}
	
  //@ ensures \result == (konto != null && konto.owner != null);
  /*@pure*/ public static boolean isValidKonto(Konto konto){
    return konto != null && konto.owner != null;
  }
}
