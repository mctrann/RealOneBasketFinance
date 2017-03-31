package obr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DataReceiver {
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

	//retrieve deposit
	public List getDepositList(){ 
		String assetCode;
		String label;
		double apr;
		List <Deposit_Account> da = new ArrayList<Deposit_Account>();
		connection();
		String query = "SELECT assetCode, assetName, apr FROM Asset WHERE assetType = 'D'";

		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				assetCode = rs.getString("assetCode");
				label = rs.getString("assetName");
				apr = rs.getInt("apr");
				Deposit_Account d = new Deposit_Account (assetCode, "D", label,apr);
				da.add(d);
			}

			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return da;
	}
	public List getStockList() {
		String code;
		String label;
		double quartDiv;
		double bRR;
		double beta;
		String stockSymbol;
		double sharePrice;

		List <Stocks> s = new ArrayList<Stocks>();

		connection();
		String query = "SELECT assetCode, assetName, quarterlyDividend, baseRateReturn,beta,stockSymbol,sharePrice FROM Asset WHERE assetType = 'S'";

		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				code = rs.getString("assetCode");
				label = rs.getString("assetName");
				quartDiv = rs.getDouble("quarterlyDividend");
				bRR = rs.getDouble("baseRateReturn");
				beta = rs.getDouble("beta");
				stockSymbol = rs.getString("stockSymbol");
				sharePrice = rs.getDouble("sharePrice");
				Stocks st = new Stocks (code, "S", label,quartDiv,bRR,beta,stockSymbol,sharePrice);
				s.add(st);
			}

			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return s;

	}

	public List getPIList() {

		String code;
		String label;
		double quartDiv;
		double bRR;
		double omega;
		double totalValue;

		List <Private_Investments> p = new ArrayList<Private_Investments>();

		connection();
		String query = "SELECT assetCode, assetName, quarterlyDividend, baseRateReturn,omega,totalValue FROM Asset WHERE assetType = 'P'";

		PreparedStatement ps = null;
		ResultSet rs=null;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				code = rs.getString("assetCode");
				label = rs.getString("assetName");
				quartDiv = rs.getDouble("quarterlyDividend");
				bRR = rs.getDouble("baseRateReturn");
				omega = rs.getDouble("omega");
				totalValue = rs.getDouble("totalValue");
				Private_Investments pi = new Private_Investments (code, "P", label,quartDiv,bRR,omega,totalValue);
				p.add(pi);
			}

			ps.close();
			conn.close();
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return p;

	}
	public List getPerson() {

		String personCode = null;
		int personID = 0;
		String firstName = null;
		String lastName = null;
		String secID = null;
		String personType = null;
		List<String> Email = new ArrayList<String>();


		List <Persons> pr = new ArrayList<Persons>();
		List<Integer> temp = new ArrayList<Integer>();
		connection();
		String query = "SELECT personID FROM Person";
		PreparedStatement ps = null;
		ResultSet rs=null;

		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while(rs.next()) {
				personID = rs.getInt("personID");
				temp.add(personID);
			}
		}
		catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String queryp = "SELECT personCode, lastName, firstName, secID, personType FROM Person WHERE personID = ?";
		String query2 = "SELECT addressID FROM Address WHERE personID = ?";
		String query3 = "SELECT stateID, countryID, street, city, zipcode FROM Address WHERE addressID = ?";
		int addressID=0;
		int stateID=0;
		int countryID=0;
		String street = null;
		String city = null;
		int zipcode=0;
		String country=null;
		String state = null;
		Address a = null;

		for(Integer t: temp) {

			try{
				ps = conn.prepareStatement(queryp);
				ps.setInt(1, t);
				rs = ps.executeQuery();
				while(rs.next()) {
					personCode = rs.getString("personCode");
					lastName = rs.getString("lastName");
					firstName = rs.getString("firstName");
					secID = rs.getString("secID");
					personType = rs.getString("personType");
					if (personType == null){
						personType="";
					}
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			try{
				ps = conn.prepareStatement(query2);
				ps.setInt(1, t);
				rs = ps.executeQuery();
				while(rs.next()){
					addressID = rs.getInt("addressID");
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			try{
				ps = conn.prepareStatement(query3);
				ps.setInt(1, addressID);
				rs = ps.executeQuery();
				while(rs.next()) {
					stateID = rs.getInt("stateID");
					countryID = rs.getInt("countryID");
					street = rs.getString("street");
					city = rs.getString("city");
					zipcode = rs.getInt("zipcode");
				}
			}
			catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			String query4 = "SELECT stateAbbreviation FROM States WHERE stateID = ?";
			try{
				ps= conn.prepareStatement(query4);
				ps.setInt(1, stateID);
				rs = ps.executeQuery();

				while(rs.next()) {
					state = rs.getString("stateAbbreviation");
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);
			}

			String query5= "SELECT countryName FROM Country WHERE countryID=?";
			try{
				ps=conn.prepareStatement(query5);
				if (countryID==0){
					country="";
				}
				else{
					ps.setInt(1, countryID);
					rs=ps.executeQuery();
					while(rs.next()){
						country=rs.getString("countryName");
					}
				}

			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);

			}
			a= new Address(street, city, state, country, Integer.toString(zipcode));
			String query6= "SELECT emailAddress FROM EmailAddress WHERE personID=?";
			try{
				ps=conn.prepareStatement(query6);
				ps.setInt(1, t);
				rs=ps.executeQuery();
				while(rs.next()){
					Email.add(rs.getString("emailAddress"));
				}
			}catch (SQLException e) {
				System.out.println("SQLException: ");
				e.printStackTrace();
				throw new RuntimeException(e);

			}

			if(personType.equals("J")) {
				Junior j = new Junior(personCode, personType, secID, firstName, lastName, a, Email);
				pr.add(j);
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
		//		else if(personType.equals("E")) {
		//			Expert e = new Expert(personCode, personType, secID, firstName, lastName, )
		//		}

		return pr;

	}
}
