package edu.calvin.cs262.server;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

@XmlRootElement
public class Player {

	private static Logger logger = Logger.getLogger("edu.calvin.cs262");

	private static String DB_URI = "jdbc:postgresql://localhost:5432/Monopoly";
	private static String DB_LOGINID = "postgres";
	private static String DB_PASSWORD = "bjarne";
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
	
	
	public static Player retrieve(int id) {
		Player result = null;
		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(DB_URI, DB_LOGINID, DB_PASSWORD);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Player WHERE id = " + id);
			if (resultSet.next()) {
				result = new Player(resultSet.getInt(1), resultSet.getString(3),
						resultSet.getString(2));
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return result;
	}
}

