package endecryption;

import java.sql.ResultSet;
import databaseconnection.DatabaseConnection;

public class getName {
	public static String name(String name) throws Exception {
		DatabaseConnection db = new DatabaseConnection();
		db.dbconnection();
		boolean flag = false;

		ResultSet rs = db
				.getResultSet("select * from files where filenamedrive = '"
						+ name + "'");
		int i = 0;
		while (!(flag)) {
			rs = db.getResultSet("select * from files where filenamedrive = '"
					+ name + "'");
			if (rs.next()) {
				i++;
				name = i + name;

			} else {
				flag = true;
			}

		}

		return name;

	}
}
