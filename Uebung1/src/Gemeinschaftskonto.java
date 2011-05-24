
public class Gemeinschaftskonto extends PersonenKonto {
  //@ public invariant owner != owner2;
  /*@non_null*/Person owner2;
  
  //@ requires owner1 != owner2;
  //@ requires owner1.isValidMarried() && owner2.isValidMarried();
  //@ ensures this.owner != null && this.owner2 != null && this.owner != this.owner2;
  public Gemeinschaftskonto(/*@non_null*/Person owner1, /*@non_null*/Person owner2) {
    super(owner1);
    this.owner2 = owner2;
  }
  
  /**
   * Einzahlen
   * 
   * @param amount: Geldbetrag, der eingezahlt wird.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) + amount;
  //@ ensures owner.total == \old(owner.total) + amount/2;
  //@ ensures owner2.total == \old(owner2.total) + amount/2;
  public void deposit(int amount, /* @non_null */BankKonto bankKonto) {
    inc(amount);
    owner.total += amount/2;
    owner2.total += amount/2;
  }

  /**
   * Auszahlen
   * 
   * @param amount: Geldbetrag, der ausgezahlt werden soll.
   */
  //@ requires amount >= 0;
  //@ ensures balance == \old(balance) - amount;
  //@ ensures owner.total == \old(owner.total) - amount/2;
  //@ ensures owner2.total == \old(owner2.total) - amount/2;
  //@ signals (LimitReached e) owner.total - amount < owner.limit;
  protected void drawOut(int amount, /* @non_null */BankKonto bankKonto)
      throws LimitReached {
    dec(amount);
    owner.total -= amount/2;
    owner2.total -= amount/2;
  }

  /**
   * Überweisung auf ein Privatkonto
   * 
   * @param amount: Geldbetrag, der überwiesen werden soll.
   * @param receiver: Empfänger des Geldes
   */
  //@ requires amount >= 0;
  //@ requires receiver != null;
  //@ requires receiver.owner != null;
  //@ ensures balance == \old(balance) - amount;
  //@ ensures owner.total == \old(owner.total) - amount/2;
  //@ ensures owner2.total == \old(owner2.total) - amount/2;
  //@ ensures receiver.balance == \old(receiver.balance) + amount;
  //@ ensures receiver.owner.total == \old(receiver.owner.total) + amount;
  //@ signals (LimitReached e) owner.total - amount/2 < owner.limit;
  //@ signals (LimitReached e) owner2.total - amount/2 < owner.limit;
  public void transfere(int amount, PrivatKonto receiver) throws LimitReached {
    dec(amount);
    owner.total -= amount/2;
    owner2.total -= amount/2;
    receiver.inc(amount);
    receiver.owner.total += amount;
  }
  
  /**
   * Überweisung auf ein Gemeinschaftskonto
   * 
   * @param amount: Geldbetrag, der überwiesen werden soll.
   * @param receiver: Empfänger des Geldes
   */
  //@ requires amount >= 0;
  //@ requires receiver != null;
  //@ requires receiver.owner != null;
  //@ ensures balance == \old(balance) - amount;
  //@ ensures owner.total == \old(owner.total) - amount/2;
  //@ ensures owner2.total == \old(owner2.total) - amount/2;
  //@ ensures receiver.balance == \old(receiver.balance) + amount;
  //@ ensures receiver.owner.total == \old(receiver.owner.total) + amount/2;
  //@ ensures receiver.owner2.total == \old(receiver.owner2.total) + amount/2;
  //@ signals (LimitReached e) owner.total - amount/2 < owner.limit;
  //@ signals (LimitReached e) owner2.total - amount/2 < owner.limit;
  public void transfere(int amount, Gemeinschaftskonto receiver) throws LimitReached {
    dec(amount);
    owner.total -= amount/2;
    owner2.total -= amount/2;
    receiver.inc(amount);
    receiver.owner.total += amount/2;
    receiver.owner2.total += amount/2;
  }
}

