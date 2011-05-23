
public class AccountHolder {  
  /** †berziehungslimit */
  int limit;
  
  //@ ensures this.limit == limit;
  public AccountHolder(int limit){
	  this.limit = limit;
  }
}
