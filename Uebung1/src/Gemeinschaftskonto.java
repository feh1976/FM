
public class Gemeinschaftskonto extends Konto {
  Person owner[] = new Person[2];
  
  //@ requires owner1 != null && owner2 != null;
  //@ requires owner1.partner == owner2 && owner2.partner == owner1;
  public Gemeinschaftskonto(Person owner1, Person owner2) {
    super();
  }
}
