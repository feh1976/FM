/**
 * Eine Person repräsentiert einen Kunden einer Bank.
 */
public class Person extends AccountHolder {
  //@ public invariant partner != this;
  //@ public invariant isMale() <==> !isFemale();
  //@ public invariant isMarried() <==> partner != null;
  //@ public invariant isMarried() ==> partner.partner == this;
  //@ public invariant isMarried() ==> male != partner.male;
  
  /** Bank, bei der man Kunde */
  /*@non_null*/Bank bank;
  
  // weitere Stammdaten:
  // Vorname, PLZ, Wohnort, Straße, Hausnummer, Telefon, ...
  
  /** Name */
  String name;
  
  /**
   * Getter-Methode für den Namen.
   * @return
   */
  //@ ensures \result == name;
  public String getName(){ return name; }
  
  /** Geschlecht */
  boolean male;

  //@ ensures \result == male;
  /*@pure*/ boolean isMale(){
    return male;
  }
  //@ ensures \result == !male;
  /*@pure*/ boolean isFemale(){
    return !male;
  }
  
  /** Ehepartner */
  Person partner;
  
  /** Einschätzung, wie kreditwürdig ein Kunde ist. */
  int bonitaet;
  
  //@ requires name.length() >= 2;
  //@ ensures this.name == name;
  //@ ensures this.male == male;
  //@ ensures bonitaet == 0;
  //@ ensures !isMarried();
  public Person(/*@non_null*/Bank bank, /*@non_null*/String name, boolean male){
	  super(0);
	  this.bank = bank;
	  this.name = name;
	  this.male = male;
	  partner = null;
	  bonitaet = 0;
	  //@ assume (\forall Person p; p.partner != this);
  }
  
  /* METHODS */
  /**
   * marry verheiratet die übergebene Person mit der hiesigen.
   * @param partner: Ehepartner
   */
  //@ requires partner != this;
  //@ requires isMale() != partner.isMale();
  //@ requires bank == partner.bank;
  //@ requires !isMarried();
  //@ requires !partner.isMarried();
  //@ ensures isValidMarried() && partner.isValidMarried();
  void marry(/*@non_null*/Person partner) {
    this.partner = partner;
    this.partner.partner = this;
  }

  //@ requires isValidMarried();
  //@ requires (\forall Gemeinschaftskonto gk; gk.owner != this && gk.owner2 != this);
  //@ requires partner.partner != null;
  //@ ensures !\old(this.partner).isMarried() && !isMarried();
  void divorce(){
    this.partner.partner = null;
    this.partner = null;
  } 
  
  //@ ensures \result == (partner != null);
  /*@pure*/ public boolean isMarried() {
    return partner != null;
  }
  //@ ensures \result == (isMarried() && partner != this && isMale() != partner.isMale() && partner.isMarried() && partner.partner == this);
  /*@pure*/ public boolean isValidMarried() {
    return isMarried() && partner != this && isMale() != partner.isMale() && partner.isMarried() && partner.partner == this;
  }
}
