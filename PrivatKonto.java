public class PrivatKonto extends Konto {
	Customer owner;
	boolean is_joint_account;

	public PrivatKonto(Customer person) {
		this.owner = person;
	}

	// Einzahlen
	public void desposit(int amount) {
		this.amount_of_balance = this.amount_of_balance + amount;
	}

	// Auszahlen
	public void drawOut(int amount) {
		if (!owner.solvencyReached(amount))
			this.amount_of_balance = this.amount_of_balance - amount;
		else {
			// Ausnahme wird geworfen
		}
	}

	// Überweisen
	public void transfer(int amount, PrivatKonto receiver) {
		if (!owner.solvencyReached(amount)) {
			this.amount_of_balance = this.amount_of_balance - amount;
			receiver.debit(amount);
		} else {
			// Ausnahme wird geworfen
		}
	}

	// Lastschrift
	public void debit(int amount) {
		this.amount_of_balance = this.amount_of_balance + amount;
	}
}
