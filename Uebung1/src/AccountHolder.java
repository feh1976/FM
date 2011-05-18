import java.util.LinkedList;


//@ public invariant konten != null;
public class AccountHolder {
  /** Liste aller Konten */
  LinkedList konten;

  /** †berziehungslimit */
  int limit;
  
  public AccountHolder(int limit){
	  konten = new LinkedList();
	  this.limit = limit;
  }
  
  //@ requires konten != null;
  public void addKonto(Konto konto){
	if (!konten.contains(konto))
	  konten.add(konto);
  }
}
