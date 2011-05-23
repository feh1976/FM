public class BankKonto extends Konto {
  //@ public invariant owner != null;
  Bank owner;
  
  int einlagerung;
  
  //@ requires bank != null;
	public BankKonto(Bank bank) {
	  super();
	  this.owner = bank;
	}

	//@ requires amount >= 0;
	//@ requires Konto.isValidKonto(konto);
  public void grantCredit(int amount, /*@non_null*/Konto konto){
    super.transfere(amount, konto );
  }
}
