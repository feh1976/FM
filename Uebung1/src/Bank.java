//@ public invariant bank != null;
public class Bank extends AccountHolder {
  private static Bank bank = new Bank();

  public Bank() {
    super(Integer.MIN_VALUE);
  }

  //@ ensures \result == bank;
  public static Bank getBank(){
    return bank;
  }
}
