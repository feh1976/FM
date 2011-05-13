
public class Gemeinschaftskonto extends Konto {
  public static Konto bank = new Konto(new Customer(true));
  public Gemeinschaftskonto(Customer owner) {
    super(owner);
  }
  
  /* Override
  public boolean isOwner(Customer person){
	  return owner == person || owner.partner == person;
  }*/
}
