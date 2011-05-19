

public class AccountHolder {
  //@ invariant num_of_konten >= 0 && num_of_konten <= konten.length;
  //@ invariant \elemtype(\typeof(konten)) == \type(Konto);
  //@ invariant (\forall int i; (0 <= i && i < num_of_konten) ==> konten[i] != null && \typeof(konten[i]) <: \type(Konto));
  
  /** Anzahl der Konten */
  int num_of_konten;
  
  /** Liste aller Konten */
  /*@ non_null */ Konto konten[];

  /** †berziehungslimit */
  int limit;
  
  //@ ensures konten != null;
  //@ ensures \elemtype(\typeof(konten)) == \type(Konto);
  //@ ensures (\forall int i; (0 <= i && i < num_of_konten) ==> konten[i] != null && \typeof(konten[i]) <: \type(Konto));
  //@ ensures this.limit == limit;
  //@ ensures num_of_konten == 0;
  public AccountHolder(int limit){
	  konten = new Konto[10];
	  this.limit = limit;
	  num_of_konten = 0;
  }
  
  /**
   * FŸgt einem Kontobesitzer ein Konto hinzu.
   * @param konto
   */
  // @ requires konto.owner == null;
  // @ requires (\forall int i; (0 <= i && i < num_of_konten) ==> konten[i] != null && konten[i] != konto);
  // @ ensures (\forall int i; (0 <= i && i < num_of_konten) ==> konten[i] != null && konten[i] != konto);
  // @ ensures num_of_konten == \old(num_of_konten) + 1;
  public void addKonto(/*@non_null@*/ Konto konto){
	  /*if (num_of_konten >= konten.length){
	    Konto newkonten[] = new Konto[num_of_konten+10];
	    System.arraycopy(konten, 0, newkonten, 0, konten.length);
	    konten = newkonten;
	  }
	  konten[num_of_konten++] = konto;*/
  }
  
  public boolean isOwner(/*@non_null@*/ Konto konto){
    for (int i = 0; i < num_of_konten; i++)
      if (konten[i] == konto)
        return true;
    return false;
  }
}
