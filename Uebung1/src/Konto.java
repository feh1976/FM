/**
 * Kontovorlage: Geldbetrag der steigt/sinkt.
 */
public class Konto {
	/** Kontostand */
	int balance;
	
  //@ ensures balance == 0;     
	public Konto(){
	  balance = 0;
	}
	
	/**
	 * Erhöht den Kontostand.
	 * @param amount: Höhe des Geldbetrages
	 */
	//@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
	public void inc(int amount){
	  balance += amount;
	}

  /**
   * Senkt den Kontostand.
   * @param amount: Höhe des Geldbetrages
   */
  //@ requires amount >= 0;
	//@ ensures balance == \old(balance) - amount;
	public void dec(int amount){
    balance -= amount;
	}

	//@ ensures \result == balance;
	/*@pure*/ public int getBalance(){
	  return balance;
	}
}
