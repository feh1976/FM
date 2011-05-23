public class BankKonto extends Konto {
//@ public invariant owner != null;
Bank owner;
  
  //@ requires bank != null;
	public BankKonto(Bank bank) {
	  super();
	  this.owner = bank;
	}
	
	
}
