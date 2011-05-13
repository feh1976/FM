
public class Bank extends Person {
	
	private static Bank bank = new Bank();
	
	public static Bank getBank(){
		return bank;
	}
}
