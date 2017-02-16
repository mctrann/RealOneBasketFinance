package obr;
import java.util.List;

public abstract class Persons {
	
	private String personCode;
	private String firstName;
	private String lastName;
	private Address address;
	private List<String> email; //TODO: HOW TO 'GET' EMAIL 
	
	public Persons(String personCode, String firstName, String lastName, Address address,List<String> email) {
		this.personCode = personCode;
		this.firstName = firstName;
		this.lastName=lastName;
		this.email = email;
		this.address = address;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getEmail() {
		return email;
	}
	
}
