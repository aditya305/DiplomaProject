package endecryption;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class file_encryption {
	public static void encryption(String source, String destination,
			String MYkey) throws IOException {
		String I = source;
		String O = destination;

		// FileRecordHandler handler = new FileRecordHandler();
		// handler.FileRecordHandler(user , filename, extension, MYkey );
		try {

			FileInputStream file = new FileInputStream(I);
			FileOutputStream outfile = new FileOutputStream(O);
			// byte k[] = "CooL2116NiTh5252".getBytes();
			byte k[] = MYkey.getBytes();
			try {
				SecretKeySpec key = new SecretKeySpec(k, "AES");
				Cipher enc = Cipher.getInstance("AES");
				enc.init(Cipher.ENCRYPT_MODE, key);
				CipherOutputStream cos = new CipherOutputStream(outfile, enc);
				byte[] buf = new byte[1024];
				int read;
				while ((read = file.read(buf)) != -1) {
					cos.write(buf, 0, read);
				}
				file.close();
				outfile.flush();
				cos.close();
				System.out.print("file incrypted");

				outfile.close();

			} catch (Exception e) {
				System.out.print(e);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.print(e);
		}
	}

}
