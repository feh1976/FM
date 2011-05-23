public class PrivatKonto extends Konto {
  //@ public invariant owner != null;
	Person owner;

	//@ requires person != null;
	public PrivatKonto(Person person) {
	  super();
		this.owner = person;
	}

  /**
   * Einzahlen
   * @param amount: Geldbetrag, der eingezahlt wird.
   */
  //@ requires owner != null;
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
  //@ ensures owner.total == \old(owner.total) + amount;
  public void deposit(int amount) {
    balance += amount;
    owner.total += amount;
  }

  /**
   * Auszahlen
   * @param amount: Geldbetrag, der ausgezahlt werden soll.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) - amount;
  //@ signals (LimitReached e) owner.total - amount < owner.limit;
  protected void drawOut(int amount) throws LimitReached {
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
  public void transfere(int amount, Konto receiver) {
    balance = balance - amount;
    receiver.inc(amount);
  }

  // Lastschrift
  public void debit(int amount) {
    balance = balance + amount;
  }
}
