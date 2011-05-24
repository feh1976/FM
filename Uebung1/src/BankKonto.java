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
  //@ ensures konto.owner.bonitaet == \old(konto.owner.bonitaet) - amount;
  //@ signals (LimitReached e) owner.openCredits + amount > owner.total + owner.total/10;
  //@ signals (CreditDenied e) konto.owner.bonitaet > amount;
  public void grantCredit(int amount, /*@non_null*/PrivatKonto konto) throws LimitReached, 
                                                                               CreditDenied {
    if (konto.owner.bonitaet > amount) throw new CreditDenied();
    if (owner.openCredits + amount > owner.total + owner.total/10) throw new LimitReached();
    dec(amount);
    konto.inc(amount);
    konto.owner.total += amount;
    konto.owner.bonitaet -= amount;
    owner.openCredits += amount;
  }
  
  /**
   * Kredit zurückzahlen von Privatkonto
   * 
   * @param amount: Geldbetrag, der zurückgezahlt wird.
   * @param konto: Konto des Kreditnehmers.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
  //@ ensures konto.balance == \old(konto.balance) - amount;
  //@ ensures konto.owner.bonitaet == \old(konto.owner.bonitaet) + amount;
  //@ ensures owner.openCredits == \old(owner.openCredits) - amount;
  //@ ensures konto.owner.total == \old(konto.owner.total) - amount;
  public void closeCredit(int amount, /*@non_null*/PrivatKonto konto) {
    inc(amount);
    konto.dec(amount);
    konto.owner.total -= amount;
    konto.owner.bonitaet += amount;
    owner.openCredits -= amount;
  }
  
  /**
   * Kredit gewähren an Gemeinschaftskonto
   * 
   * @param amount: Geldbetrag, der als Kredit gewährt wird.
   * @param konto: Konto des Kreditnehmers.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) - amount;
  //@ ensures konto.balance == \old(konto.balance) + amount;
  //@ ensures konto.owner.total == \old(konto.owner.total) + amount/2 + amount%2;
  //@ ensures konto.owner2.total == \old(konto.owner2.total) + amount/2;
  //@ ensures konto.owner.bonitaet == \old(konto.owner.bonitaet) - amount/2 - amount%2;
  //@ ensures konto.owner2.bonitaet == \old(konto.owner2.bonitaet) - amount/2;
  //@ ensures owner.openCredits == \old(owner.openCredits) + amount;
  //@ signals (LimitReached e) owner.openCredits + amount > owner.total + owner.total/10;
  //@ signals (CreditDenied e) konto.owner.bonitaet  > amount/2 + amount%2 || konto.owner2.bonitaet  > amount/2;
  public void grantCredit(int amount, /*@non_null*/Gemeinschaftskonto konto) throws LimitReached, 
                                                                               CreditDenied {
    if (konto.owner.bonitaet  > amount/2 + amount%2 || konto.owner2.bonitaet  > amount/2) throw new CreditDenied();
    if (owner.openCredits + amount > owner.total + owner.total/10) throw new LimitReached();
    dec(amount);
    konto.inc(amount);
    konto.owner.total += amount/2 + amount%2;
    konto.owner2.total += amount/2;
    konto.owner.bonitaet -= amount/2 + amount%2;
    konto.owner2.bonitaet -= amount/2;
    owner.openCredits += amount;
  }
  
  /**
   * Kredit zurückzahlen von Gemeinschaftskonto
   * 
   * @param amount: Geldbetrag, der zurückgezahlt wird.
   * @param konto: Konto des Kreditnehmers.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
  //@ ensures konto.balance == \old(konto.balance) - amount;
  //@ ensures owner.openCredits == \old(owner.openCredits) - amount;
  //@ ensures konto.owner.total == \old(konto.owner.total) - amount/2 - amount%2;
  //@ ensures konto.owner2.total == \old(konto.owner2.total) - amount/2;
  //@ ensures konto.owner.bonitaet == \old(konto.owner.bonitaet) + amount/2 + amount%2;
  //@ ensures konto.owner2.bonitaet == \old(konto.owner2.bonitaet) + amount/2;
  public void closeCredit(int amount, /*@non_null*/Gemeinschaftskonto konto) {
    inc(amount);
    konto.dec(amount);
    konto.owner.total -= amount/2 - amount%2;
    konto.owner2.total -= amount/2;
    konto.owner.bonitaet += amount/2 + amount%2;
    konto.owner2.bonitaet += amount/2;
    owner.openCredits -= amount;
  }
  
}
