import java.util.LinkedList;

/* 
  This assignment illustrates how specifications (esp invariants and 
  preconditions)  written in a formal language can help in removing 
  errors in code. 

  The assignment concerns a class "Customer" that is used for taxpayers.
 */
class Customer extends Person{
 /* FIELDS */
	Liste konten = new Liste();

  /* isMale is true if the person is male */
  boolean isMale;

  /* Reference to partner if person is married, null otherwise */
  Customer partner = null; 

  int limit;

  /* CONSTRUCTOR */
  Customer(boolean isMale) {
    this.isMale = isMale;
    //@ assume (\forall Customer c; c.partner != this); 
  }

 /* METHODS */

  void marry(Customer partner) {
	  this.partner = partner;
    //partner.partner = this;
  }
  public boolean isMarried(){ return partner != null; }
 
  /* Divorce  */
  void divorce() {
    //partner.partner = null;
    //partner = null;
  }
}
