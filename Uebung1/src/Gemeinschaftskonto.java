
public class Gemeinschaftskonto extends Konto {
  //@ public invariant owner1 != owner2;
  /*@non_null*/Person owner1;
  /*@non_null*/Person owner2;
  
  //@ requires owner1 != owner2;
  //@ requires owner1.partner == owner2 && owner2.partner == owner1;
  //@ ensures this.owner1 != null && this.owner2 != null && this.owner1 != this.owner2;
  public Gemeinschaftskonto(/*@non_null*/Person owner1, /*@non_null*/Person owner2) {
    super();
    this.owner1 = owner1;
    this.owner2 = owner2;
  }
}
