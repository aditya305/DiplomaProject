package dbmanager;

import java.sql.ResultSet;
import java.sql.SQLException;

import sendmail.SimpleSendEmail;
import databaseconnection.DatabaseConnection;

public class datamanager {


	public static void UploadLog(String filename, String FileExtansionname, String filehash, String username, String Size,String logo,String key) throws SQLException {
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		
		String sql = "select emailid from user where username = '"+username+"'";
		ResultSet rs = db.getResultSet(sql);
		
		if(rs.next()){
			
			SimpleSendEmail emails = new SimpleSendEmail(rs.getString(1),"File Report ", filename +" sucessfully uploaded decryption key is "+key);
			
			String Query = "insert into files values('" + filename + "','"
					+ FileExtansionname + "','" + Size + "','" + filehash + "','" +  username+ "','" +logo+ "','"+key+"')";
			
			System.out.println(Query);
			int i = db.getUpdate(Query);

			db.closeConnection(db);
		}
		
		
		
		
	}

}
