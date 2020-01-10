package endecryption;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileRecordHandler {
	public static void FileRecordHandler(String source, String destination,
			String filename, String extension, String MYkey, String fextn,
			String user , String fileformat) {

		String db = "seedblock";
		String username = "root";
		String password = "root";
		Connection con = null;

		try {
			String url = "jdbc:mysql://localhost:3306/" + db;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, username, password);

			String afilepath = "D:/shailesh/client/seedblock/" + user + "/"
					+ extension;

			String sql = "insert into data (fextn, filename, filepath, afilepath, mykey,user,fileformat)"
					+ "VALUES (?,?,?,?,?,?,?)";

			PreparedStatement psmt = con.prepareStatement(sql);

			psmt.setString(1, fextn);
			psmt.setString(2, filename);
			psmt.setString(3, source);
			psmt.setString(4, afilepath);
			psmt.setString(5, MYkey);
			psmt.setString(6, user);
			psmt.setString(7, fileformat);
			psmt.executeUpdate();

			{
				System.out.println("dataBase updated for " + user);

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
