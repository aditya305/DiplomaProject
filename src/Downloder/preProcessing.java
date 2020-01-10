package Downloder;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import uploader.Dropbox;
import uploader.path;
import fakeobject.Signature;
import databaseconnection.DatabaseConnection;
import endecryption.DecryptFile;
import endecryption.EncryptFile;

public class preProcessing {

	public static String preProcessing(String user, String key, String file,
			DatabaseConnection db, String shuser) {
		String sql = " select filenamedrive,enckey from  files where uploder='"
				+ user + "' and enckey = '" + key + "' and filenameextn='"
				+ file + "'";

		ResultSet rs = db.getResultSet(sql);

		try {
			if (rs.next()) {
				String filenamedrive = rs.getString("filenamedrive");
				String enckey = rs.getString("enckey");
				Dropbox.fileDownalod_from_dropbox("/" + filenamedrive,
						path.path + shuser + "/" + filenamedrive);

				DecryptFile dec = new DecryptFile(enckey);
				String decrypt_file = path.path + shuser + "/" + random()
						+ filenamedrive;
				dec.decrypt(path.path + user + "/" + filenamedrive,
						decrypt_file);

				test.test.insert(shuser, decrypt_file);

				return decrypt_file;
			} else {
				return "";
			}
		} catch (Exception e) {
			System.out.println("e:" + e);
		}
		return "";

	}

	public static String random() {

		StringBuilder generatedToken = new StringBuilder();
		try {
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			// Generate 20 integers 0..20
			for (int i = 0; i < 6; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedToken.toString();
	}
}
