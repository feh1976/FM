public class Bank extends AccountHolder {
  //@ public invariant bank != null;
  private static Bank bank = new Bank();

  public Bank() {
    super(Integer.MIN_VALUE);
  }

  //@ ensures \result == bank;
  public static Bank getBank(){
    return bank;
  }
}
