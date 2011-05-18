/* 
  This assignment illustrates how specifications (esp invariants and 
  preconditions)  written in a formal language can help in removing 
  errors in code. 

  The assignment concerns a class "Customer" that is used for taxpayers.
 */
class Customer extends Person {

	/* isMale is true if the person is male */
	boolean isMale;

	/* Reference to partner if person is married, null otherwise */
	Customer partner = null;

	int limit;

	/* CONSTRUCTOR */
	Customer(boolean isMale) {
		super();
		this.isMale = isMale;
		// @ assume (\forall Customer c; c.partner != this);
	}

	/* METHODS */

	void marry(Customer partner) {
		this.partner = partner;
		// partner.partner = this;
	}

	public boolean isMarried() {
		return partner != null;
	}

	/* Divorce */
	void divorce() {
		// partner.partner = null;
		// partner = null;
	}

	// Konto hinzufügen
	public void addKonto() {
		this.konten.add(new PrivatKonto(this));
	}

	// Kreditwürdigkeit überprüfen
	public boolean isCreditWorth(int amount) {
		if (this.isMarried()) {
			if (this.solvency + this.partner.solvency >= amount)
				return true;
		} else {
			if (this.solvency >= amount)
				return true;
		}
		return false;
	}

	// Dispolimit für alle Konten überprüfen
	public boolean solvencyReached(int amount) {
		int total = 0;
		for (int i = 0; i < this.konten.size(); i++) {
			PrivatKonto konto = (PrivatKonto) this.konten.getItemAt(i);
			// Überziehungen eines Gemeinschaftskonto werden je zur Hälfte
			// den beiden Ehegatten zugeschrieben
			if (konto.is_joint_account)
				total = total + konto.amount_of_balance / 2;
			else
				total = total + konto.amount_of_balance;
		}
		if (this.solvency >= total + amount) {
			return true;
		}
		return false;
	}

}
