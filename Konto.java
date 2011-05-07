
public class Konto {
  Person owner;

  public Konto (Person person){
	  this.owner = person;
  }
  
  public boolean isOwner(Customer person){
	  return owner == person;
  }
}
