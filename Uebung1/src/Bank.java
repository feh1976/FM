public class Bank extends AccountHolder {
//@ public invariant bank != null;
  
  private static Bank bank = new Bank();
 
  /** Eigenes Konto */
  /*@ non_null */ BankKonto bank_konto = new BankKonto(bank);
  
  
  public Bank() {
    super(Integer.MIN_VALUE);
  }

  //@ ensures \result == bank;
  public static Bank getBank() {
    return bank;
  }

  /**
   * Bankeinlagen
   * 
   * @returns : Summe aller Kontostände auf dieser Bank.
   */
  //@ requires (\forall int i; (0 <= i && i < num_of_konten) ==> konten[i] != null);
  //@ ensures \result == (\sum int i; 0 <= i && i < konten.length; konten[i].balance) + bank_konto.balance;
  public int getBankMoney() {
    int bank_money = bank_konto.balance;
    //@ assert bank_money == bank_konto.balance;
    for (int i = 0; i < konten.length; i++)
      bank_money =+ konten[i].balance;      
    return bank_money;
  }
}
