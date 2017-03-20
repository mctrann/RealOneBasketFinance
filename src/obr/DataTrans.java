package obr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DataTrans {

	List<Stocks> stockArray = new ArrayList<Stocks>();
	List<Deposit_Account> depAccArray = new ArrayList<Deposit_Account>();
	List<Private_Investments> privInvesArray = new ArrayList<Private_Investments>();

	public static void dataTransfer() {
		
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

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(DatabaseInfo.url, DatabaseInfo.username, DatabaseInfo.password);
		} catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		String query = "INSERT INTO Asset (assetCode, assetName, assetType, apr, quartDiv, BRR, beta, omega, stockSymbol, totalValue, sharePrice) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement ps = null;

		Data_Converter arrays = new Data_Converter();
		
		try {
			ps = conn.prepareStatement(query);
			for(Assets a : arrays.getAssetInfo()) {
				
				ps.setString(1, a.getCode());
				ps.setString(2, a.getLabel());
				ps.setString(3, a.getType());
				
				if(a.getType().equals("D")) {
					Deposit_Account da = (Deposit_Account) a;
					ps.setDouble(4, da.getAPR());
					ps.setNull(5, Types.DOUBLE);
					ps.setNull(6, Types.DOUBLE);
					ps.setNull(7, Types.DOUBLE);
					ps.setNull(8, Types.DOUBLE);
					ps.setNull(9, Types.DOUBLE);
					ps.setNull(10, Types.VARCHAR);
					ps.setNull(11, Types.DOUBLE);
					ps.setNull(11, Types.DOUBLE);
					ps.executeUpdate();
				}
				else if(a.getType().equals("S")){
					Stocks s = (Stocks) a;
					ps.setNull(4, Types.DOUBLE);
					ps.setDouble(5, s.getQuartDiv());
					ps.setDouble(6, s.getBRR());
					ps.setDouble(7, s.getRiskMeasure());
					ps.setNull(8, Types.DOUBLE);
					ps.setString(9, s.getStockSymbol());
					ps.setNull(10, Types.DOUBLE);
					ps.setDouble(11, s.getSharePrice());
					ps.executeUpdate();
				}
				else {
					Private_Investments pv = (Private_Investments) a;
					ps.setNull(4, Types.DOUBLE);
					ps.setDouble(5, pv.getQuartDiv());
					ps.setDouble(6, pv.getBRR());
					ps.setNull(7, Types.DOUBLE);
					ps.setDouble(8, pv.getRiskMeasure());
					ps.setNull(9, Types.VARCHAR);
					ps.setDouble(10, pv.getPVValue());
					ps.setNull(11, Types.DOUBLE);
					ps.executeUpdate();
				}
			}
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		String query2 = "INSERT INTO Person (personCode, lastName, firstName, secID, personType) VALUES (?,?,?,?,?)";
		try{
			
			for(Persons p : arrays.getPerInfo()) {
				ps = conn.prepareStatement(query2);
				ps.setString(1, p.getPersonCode());
				ps.setString(2, p.getLastName());
				ps.setString(3, p.getFirstName());
				ps.setString(4, p.getSecID());
				ps.setString(5, p.getType());
				ps.executeUpdate();
			}	
			ps.close();
		}catch (SQLException e) {
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}

	public static void main(String arg[]) {
		dataTransfer();
	}
}
