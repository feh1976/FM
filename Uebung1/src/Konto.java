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
	 * Einzahlen
	 * @param amount: Geldbetrag, der eingezahlt wird.
	 */
	//@ requires owner != null;
	//@ requires amount >= 0;
	//@ ensures balance == \old(balance) + amount;
  //@ ensures owner.total == \old(owner.total) + amount;
	protected void deposit(int amount) {
		balance += amount;
		owner.total += amount;
	}

	/**
	 * Auszahlen
	 * @param amount: Geldbetrag, der ausgezahlt werden soll.
	 */
	//@ requires amount >= 0;
	// TODO: limit testen sonst Exception werfen
	//@ ensures balance == \old(balance) - amount;
	protected void drawOut(int amount) {
		balance = balance - amount;
	}

	/**
	 * †berweisung
	 * @param amount: Geldbetrag, der Ÿberwiesen werden soll.
	 * @param receiver: EmpfŠnger des Geldes
	 */
	//@ requires amount >= 0;
	//@ requires receiver != null;
	//@ requires receiver.owner != null;
	//@ ensures balance == \old(balance) - amount;
	//@ ensures receiver.balance == \old(receiver.balance) + amount; 
	protected void transfere(int amount, Konto receiver) {
		balance = balance - amount;
		receiver.deposit(amount);
	}

	// Lastschrift
	protected void debit(int amount) {
		balance = balance + amount;
	}
	
	//@ ensures \result == (konto != null && konto.owner != null);
	/*@pure*/ public static boolean isValidKonto(Konto konto){
	  return konto != null && konto.owner != null;
	}
}
