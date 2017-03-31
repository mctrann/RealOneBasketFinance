package obr; //DO NOT CHANGE THIS
//com.sdb
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

/**
 * This is a collection of utility methods that define a general API for
 * interacting with the database supporting this application.
 *
 */
public class PortfolioData {

	static Connection conn=null;
	
	public static void connection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			System.out.println("InstantiationException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			System.out.println("IllegalAccessException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	/**
	 * Method that removes every person record from the database
	 */
	public static void removeAllPersons() {
		connection();

		PreparedStatement ps = null;

		String query = "DELETE FROM Portfolio";

		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query2 = "DELETE * FROM Person";

		try{
			ps = conn.prepareStatement(query2);
			ps.executeUpdate();

		}catch(SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException();
		}

		String query3 = "DELETE FROM Address";

		try{
			ps = conn.prepareStatement(query3);
			ps.executeUpdate();
		}catch(SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException();
		}

		String query4 = "DELETE FROM EmailAddress";

		try{
			ps = conn.prepareStatement(query4);
			ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * Removes the person record from the database corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 */
	public static void removePerson(String personCode) {
		connection();

		PreparedStatement ps = null;

		String query = "DELETE FROM Portfolio WHERE managerID =? ";

		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query2 = "DELETE FROM Portfolio WHERE ownerID =? ";

		try{
			ps = conn.prepareStatement(query2);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query3 = "DELETE FROM Portfolio WHERE beneficiaryID =? ";

		try{
			ps = conn.prepareStatement(query3);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query4 = "DELETE FROM Person WHERE personID =? ";

		try{
			ps = conn.prepareStatement(query4);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query5 = "DELETE FROM Address WHERE personID =? ";

		try{
			ps = conn.prepareStatement(query5);
			ps.setString(1, personCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query6 = "DELETE FROM EmailAddress WHERE  =? ";

		try{
			ps = conn.prepareStatement(query6);
			ps.setString(1, personCode);
			ps.executeUpdate();
			ps.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Method to add a person record to the database with the provided data. The
	 * <code>brokerType</code> will either be "E" or "J" (Expert or Junior) or 
	 * <code>null</code> if the person is not a broker.
	 * @param personCode
	 * @param firstName
	 * @param lastName
	 * @param street
	 * @param city
	 * @param state
	 * @param zip
	 * @param country
	 * @param brokerType
	 */
	@SuppressWarnings("null")
	public static void addPerson(String personCode, String firstName, String lastName, String street, String city, String state, String zip, String country, String brokerType, String secBrokerId) {
		connection();


		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "INSERT INTO Person (personCode, lastName, firstName, secID, personType) VALUES (?,?,?,?,?)";
		int personID = 0;

		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, personCode);
			ps.setString(2, lastName);
			ps.setString(3, firstName);
			if(secBrokerId.equals("")) {
				ps.setNull(4, Types.VARCHAR);
			}
			else {
				ps.setString(4, secBrokerId);
			}
			if(brokerType.equals("")) {
				ps.setNull(5, Types.VARCHAR);
			}
			else{
				ps.setString(5, brokerType);
			}
			ps.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try{
			ps = conn.prepareStatement("SELECT LAST_INSERT_ID()");
			rs = ps.executeQuery();
			while(rs.next()) {
				personID = rs.getInt("LAST_INSERT_ID()");
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}


		String query2 = "SELECT stateID FROM States WHERE stateAbbreviation = ?";

		int stateID = 0;

		try {
			ps = conn.prepareStatement(query2);
			ps.setString(1, state);
			rs = ps.executeQuery();

			while(rs.next()) {
				stateID = rs.getInt("stateID");
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query3 = "SELECT countryID FROM Country WHERE countryName = ?";

		int countryID = 0;

		try{
			ps = conn.prepareStatement(query3);
			if(country.equals("")){
			}
			else{
				ps.setString(1, country);
				rs = ps.executeQuery();
				while(rs.next()){
					countryID = rs.getInt("countryID");
				}
			}

		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query4 = "INSERT INTO Address(personID, stateID, countryID, street, city, zipcode) VALUES (?,?,?,?,?,?)";
		try{
			ps = conn.prepareStatement(query4);

			ps.setInt(1, personID);
			ps.setInt(2, stateID);
			if(countryID == 0) {
				ps.setNull(3, Types.INTEGER);
			}
			else {
				ps.setInt(3, countryID);
			}
			ps.setString(4, street);
			ps.setString(5, city);
			ps.setString(6, zip);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds an email record corresponding person record corresponding to the
	 * provided <code>personCode</code>
	 * @param personCode
	 * @param email
	 */
	public static void addEmail(String personCode, List<String> email) {

		connection();


		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT personID FROM Person WHERE personCode = ?";
		int personID = 0;

		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, personCode);
			rs = ps.executeQuery();


			while(rs.next()) {
				personID = rs.getInt("personID");
			}

		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		for(String em: email) {
			if(em.equals("")) {
			}
			else{
				String query2 = "INSERT INTO EmailAddress (emailAddress, personID) VALUES (?,?)";

				try{
					ps = conn.prepareStatement(query2);

					ps.setString(1, em);
					ps.setInt(2, personID);
					ps.executeUpdate();
				}
				catch (SQLException e) {
					System.out.println("SQLException: ");
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}

		try{
			ps.close();
			conn.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Removes all asset records from the database
	 */
	public static void removeAllAssets() {
		connection();

		PreparedStatement ps = null;

		String query = "DELETE FROM Asset";

		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query2 = "DELETE FROM PortAsset";

		try{
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Removes the asset record from the database corresponding to the
	 * provided <code>assetCode</code>
	 * @param assetCode
	 */
	public static void removeAsset(String assetCode) {
		connection();

		PreparedStatement ps = null;

		String query = "DELETE FROM Asset where assetID=?";

		try{
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.executeUpdate();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		String query2 = "DELETE FROM PortAsset where assetID=?";

		try{
			ps = conn.prepareStatement(query2);
			ps.setString(1, assetCode);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds a deposit account asset record to the database with the
	 * provided data. 
	 * @param assetCode
	 * @param label
	 * @param apr
	 */

	public static void addDepositAccount(String assetCode, String label, double apr) {
		connection();

		String query = "INSERT INTO Asset (assetCode, assetName, assetType, apr, quarterlyDividend, baseRateReturn, beta, omega, stockSymbol, totalValue, sharePrice) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = null;
		try{
			ps = conn.prepareStatement(query);

			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setString(3, "D");
			ps.setDouble(4, apr);
			ps.setNull(5, Types.DOUBLE);
			ps.setNull(6, Types.DOUBLE);
			ps.setNull(7, Types.DOUBLE);
			ps.setNull(8, Types.DOUBLE);
			ps.setNull(9, Types.DOUBLE);
			ps.setNull(10, Types.VARCHAR);
			ps.setNull(11, Types.DOUBLE);
			ps.setNull(11, Types.DOUBLE);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds a private investment asset record to the database with the
	 * provided data.  The <code>baseRateOfReturn</code> is assumed to be on the
	 * scale [0, 1].
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param baseOmega
	 * @param totalValue
	 */
	public static void addPrivateInvestment(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double baseOmega, Double totalValue) {

		connection();
		String query = "INSERT INTO Asset (assetCode, assetName, assetType, apr, quarterlyDividend, baseRateReturn, beta, omega, stockSymbol, totalValue, sharePrice) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = null;


		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setString(3, "P");

			ps.setNull(4, Types.DOUBLE);
			ps.setDouble(5, quarterlyDividend);
			ps.setDouble(6, baseRateOfReturn);
			ps.setNull(7, Types.DOUBLE);
			ps.setDouble(8, baseOmega);
			ps.setNull(9, Types.VARCHAR);
			ps.setDouble(10, totalValue);
			ps.setNull(11, Types.DOUBLE);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Adds a stock asset record to the database with the
	 * provided data.  The <code>baseRateOfReturn</code> is assumed to be on the 
	 * scale [0, 1].
	 * @param assetCode
	 * @param label
	 * @param quarterlyDividend
	 * @param baseRateOfReturn
	 * @param beta
	 * @param stockSymbol
	 * @param sharePrice
	 */



	public static void addStock(String assetCode, String label, Double quarterlyDividend, 
			Double baseRateOfReturn, Double beta, String stockSymbol, Double sharePrice) {
		connection();

		String query = "INSERT INTO Asset (assetCode, assetName, assetType, apr, quarterlyDividend, baseRateReturn, beta, omega, stockSymbol, totalValue, sharePrice) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query);

			ps.setString(1, assetCode);
			ps.setString(2, label);
			ps.setString(3, "S");
			ps.setNull(4, Types.DOUBLE);
			ps.setDouble(5, quarterlyDividend);
			ps.setDouble(6, baseRateOfReturn);
			ps.setDouble(7, beta);
			ps.setNull(8, Types.DOUBLE);
			ps.setString(9, stockSymbol);
			ps.setNull(10, Types.DOUBLE);
			ps.setDouble(11, sharePrice);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Removes all portfolio records from the database
	 */
	public static void removeAllPortfolios() {}

	/**
	 * Removes the portfolio record from the database corresponding to the
	 * provided <code>portfolioCode</code>
	 * @param portfolioCode
	 */
	public static void removePortfolio(String portfolioCode) {}

	/**
	 * Adds a portfolio records to the database with the given data.  If the portfolio has no
	 * beneficiary, the <code>beneficiaryCode</code> will be <code>null</code>
	 * @param portfolioCode
	 * @param ownerCode
	 * @param managerCode
	 * @param beneficiaryCode
	 */
	public static void addPortfolio(String portfolioCode, String ownerCode, String managerCode, String beneficiaryCode) {
		connection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT personID FROM Person WHERE personCode = ?";
		int ownerID = 0;
		try{
			ps = conn.prepareStatement(query);

			ps.setString(1, ownerCode);
			rs = ps.executeQuery();

			while(rs.next()) {
				ownerID = rs.getInt("personID");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query2 = "SELECT personID FROM Person where personCode = ?";
		int managerID = 0;
		try{
			ps = conn.prepareStatement(query2);

			ps.setString(1, managerCode);
			rs = ps.executeQuery();

			while(rs.next()) {
				managerID = rs.getInt("personID");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query3 = "SELECT personID FROM Person where personCode = ?";
		int beneficiaryID = 0;
		if(beneficiaryCode.equals("")) {
	
		}
		else{
			try{
				ps = conn.prepareStatement(query3);

				ps.setString(1, beneficiaryCode);
				rs = ps.executeQuery();

				while(rs.next()) {
					beneficiaryID = rs.getInt("personID");
				}
			} catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		String query4 = "INSERT INTO Portfolio (managerID, ownerID, beneficiaryID, portCode) VALUES (?,?,?,?)";

		try{
			ps = conn.prepareStatement(query4);

			ps.setInt(1, managerID);
			ps.setInt(2, ownerID);
			if(beneficiaryID==0) {
				ps.setNull(3, Types.INTEGER);
			}
			else{
				ps.setInt(3, beneficiaryID);
			}
			ps.setString(4, portfolioCode);
			ps.executeUpdate();
			ps.close();
			conn.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * Associates the asset record corresponding to <code>assetCode</code> with the 
	 * portfolio corresponding to the provided <code>portfolioCode</code>.  The third 
	 * parameter, <code>value</code> is interpreted as a <i>balance</i>, <i>number of shares</i>
	 * or <i>stake percentage</i> (on the scale [0, 1]) depending on the type of asset the <code>assetCode</code> is
	 * associated with.  
	 * @param portfolioCode
	 * @param assetCode
	 * @param value
	 */
	public static void addAsset(String portfolioCode, String assetCode, double value) {
		connection();

		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = "SELECT portfolioID FROM Portfolio WHERE portCode = ?";
		int portfolioID = 0;

		try{
			ps = conn.prepareStatement(query);

			ps.setString(1, portfolioCode);
			rs = ps.executeQuery();

			while(rs.next()) {
				portfolioID = rs.getInt("portfolioID");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query2 = "SELECT assetID FROM Asset WHERE assetCode = ?";
		int assetID = 0;

		try{
			ps = conn.prepareStatement(query2);

			ps.setString(1, assetCode);
			rs = ps.executeQuery();

			while(rs.next()) {
				assetID = rs.getInt("assetID");
			}
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query3 = "INSERT INTO PortAsset (assetID, portfolioID, portAssetValue) VALUES (?,?,?)";

		try{
			ps = conn.prepareStatement(query3);

			ps.setInt(1, assetID);
			ps.setInt(2, portfolioID);
			ps.setDouble(3, value);
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
