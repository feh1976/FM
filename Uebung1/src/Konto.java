public class Konto {
  /** Accountbesitzer */
  AccountHolder owner;
	/** Kontostand */
	int balance;
	
	public Konto(){
	  balance = 0;
	}
	
	/**
	 * Einzahlen
	 * @param amount: Geldbetrag, der eingezahlt wird.
	 */
	//@ requires amount >= 0;
	//@ ensures balance == \old(balance) + amount;
	public void deposit(int amount) {
		balance += amount;
	}

	/**
	 * Auszahlen
	 * @param amount: Geldbetrag, der ausgezahlt werden soll.
	 */
	//@ requires amount >= 0;
	// TODO: limit testen sonst Exceptionw werfen
	//@ ensures balance == \old(balance) - amount;
	public void drawOut(int amount) {
		balance = balance - amount;
	}

	/**
	 * †berweisung
	 * @param amount: Geldbetrag, der Ÿberwiesen werden soll.
	 * @param receiver: EmpfŠnger des Geldes
	 */
	//@ requires amount >= 0;
	//@ requires receiver != null;
	//@ ensures balance == \old(balance) - amount;
	//@ ensures receiver.balance == \old(receiver.balance) + amount; 
	public void transfer(int amount, Konto receiver) {
		balance = balance - amount;
		receiver.deposit(amount);
	}

	// Lastschrift
	public void debit(int amount) {
		balance = balance + amount;
	}
}
