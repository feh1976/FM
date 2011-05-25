/**
 * Konto, dass einer Person gehört.
 */
public class PersonenKonto extends Konto {
  /** Kontobesitzer */
  /*@non_null*/Person owner;
  
  //@ ensures owner == person;
  public PersonenKonto(/*@non_null*/Person person) {
    super();
    owner = person;
  }
}
