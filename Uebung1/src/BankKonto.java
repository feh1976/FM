public class BankKonto extends Konto {
  //@ public invariant owner != null;
  Bank owner;
  
  /** Deponiertes Geld aller Kunden */
  int einlagerung;
  
  //@ requires bank != null;
	public BankKonto(Bank bank) {
	  super();
	  this.owner = bank;
	}

	//@ requires konto != this;
	//@ requires amount >= 0;
	//@ requires Konto.isValidKonto(konto);
	// @ ensures getBalance() == \old(getBalance()) - amount;
  // @ ensures konto.getBalance() == \old(konto.getBalance()) + amount;
  public void grantCredit(int amount, /*@non_null*/Konto konto){
    dec(amount);
    konto.inc(amount);
  }
}
