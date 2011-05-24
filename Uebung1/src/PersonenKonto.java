
public class PersonenKonto extends Konto {
 //@ public invariant owner != null;
  Person owner;
  
  //@ requires person != null;
  //@ ensures owner == person;
  public PersonenKonto(Person person) {
    super();
    this.owner = person;
  }
}
