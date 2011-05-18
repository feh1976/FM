//@ public invariant isMarried() <==> (partner != null);
//@ public invariant isMarried() ==> partner.partner == this;
public class Person extends AccountHolder {
  /** Ehepartner */
  Person partner = null;
  /** BonitŠt */
  int solvency = 0;
  
  public Person(){
	  super(0);
  }
  
  /* METHODS */
  //@ requires partner != null;
  //@ requires this.partner == null && partner.partner == null;
  //@ ensures this.partner == partner && partner.partner == this;
  void marry(Person partner) {
    this.partner = partner;
    partner.partner = this;
  }

  //@ ensures \result == (partner != null);
  public boolean isMarried() {
    return partner != null;
  }

  /** Divorce */
  void divorce() {
    // partner.partner = null;
    // partner = null;
  }
}
