//@ public invariant owner != null;
public class PrivatKonto extends Konto {
	Person owner;

	public PrivatKonto(Person person) {
		this.owner = person;
	}
}
