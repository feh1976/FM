
public class Gemeinschaftskonto extends Konto {
//@ public invariant owner[0] != null;
//@ public invariant owner[1] != null;
  Person owner[] = new Person[2];
  
  //@ requires owner1 != null && owner2 != null;
  //@ requires owner1.partner == owner2 && owner2.partner == owner1;
  public Gemeinschaftskonto(Person owner1, Person owner2) {
    super();
    this.owner[0] = owner1;
    this.owner[1] = owner2;
  }
}
