public class PrivatKonto extends Konto {
//@ public invariant owner != null;
	Person owner;

	//@ requires person != null;
	public PrivatKonto(Person person) {
	  super();
		this.owner = person;
	}
}
