public class BankKonto extends Konto {
  //@ public invariant owner != null;
  Bank owner;
    
  //@ requires bank != null;
  //@ ensures owner == bank;
	public BankKonto(Bank bank) {
	  super();
	  this.owner = bank;
	}

	/**
   * Kredit gewähren an Privatkonto
   * 
   * @param amount: Geldbetrag, der als Kredit gewährt wird.
   * @param konto: Konto des Kreditnehmers.
   */
	//@ requires amount >= 0;
  //@ ensures balance == \old(balance) - amount;
  //@ ensures konto.balance == \old(konto.balance) + amount;
  //@ ensures konto.owner.total == \old(konto.owner.total) + amount;
  //@ ensures owner.openCredits == \old(owner.openCredits) + amount;
  //@ signals (LimitReached e) owner.openCredits + amount > owner.total + owner.total/10;
  //@ signals (CreditDenied e) konto.owner.bonitaet > amount;
  public void grantCredit(int amount, /*@non_null*/PersonenKonto konto) throws LimitReached, 
                                                                               CreditDenied {
    dec(amount);
    konto.inc(amount);
    konto.owner.total += amount;
    owner.openCredits += amount;
  }
  
  /**
   * Kredit zurückzahlen an Privatkonto
   * 
   * @param amount: Geldbetrag, der zurückgezahlt wird.
   * @param konto: Konto des Kreditnehmers.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
  //@ ensures konto.balance == \old(konto.balance) - amount;
  //@ ensures owner.openCredits == \old(owner.openCredits) - amount;
  //@ ensures konto.owner.total == \old(konto.owner.total) - amount;
  public void closeCredit(int amount, /*@non_null*/PersonenKonto konto) {
    inc(amount);
    konto.dec(amount);
    konto.owner.total -= amount;
    owner.openCredits -= amount;
  }
  
}
