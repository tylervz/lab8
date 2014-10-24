package edu.calvin.cs262.server;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
public class Player {

	private int id;
	private String name, emailAddress;

	public Player() {
		this(0, "John", "john@somewhere.something");
	}
	
	public Player(String name, String emailaddress) {
		this.name = name;
		this.emailAddress = emailaddress;
	}

	public Player(int id, String name, String emailaddress) {
		this.id = id;
		this.name = name;
		this.emailAddress = emailaddress;
	}

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmailAddress() { return emailAddress; }
	public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

	@Override
	public String toString() { return getId() + ", " + getName() + ", " + getEmailAddress(); }
}
