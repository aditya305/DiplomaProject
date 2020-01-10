//package endecryption;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//
//import javax.crypto.Cipher;
//import javax.crypto.CipherOutputStream;
//import javax.crypto.spec.SecretKeySpec;
//
//public class decryptor {
//
//	public static void main(String args[]) {
////		main("D:/eclipse-2015/project 2015/WorkspaceTowork/HybridIDS/userdata/shailesh/1An Efficient Hybrid Usage-Based Ranking Model for Information.pdf",
////				"D:/eclipse-2015/project 2015/WorkspaceTowork/HybridIDS/userdata/shailesh/2An Efficient Hybrid Usage-Based Ranking Model for Information.pdf",
////				"MjbQ1882RhFf4040");
//	}
//
//	public static void main(String source, String destination, String dkey) {
//		String f = source;
//
//		String o = destination;
//		try {
//			FileInputStream file = new FileInputStream(f);
//			FileOutputStream outfile = new FileOutputStream(o);
//
//			// byte k[] = "CooL2116NiTh5252".getBytes();
//
//			byte k[] = dkey.getBytes();
//			System.out.print(k);
//
//			try {
//				SecretKeySpec key = new SecretKeySpec(k, "AES");
//				Cipher enc = Cipher.getInstance("AES");
//				enc.init(Cipher.DECRYPT_MODE, key);
//				CipherOutputStream cos = new CipherOutputStream(outfile, enc);
//				byte[] buf = new byte[1024];
//				int read;
//				while ((read = file.read(buf)) != -1) {
//					cos.write(buf, 0, read);
//				}
//				file.close();
//				outfile.flush();
//				cos.close();
//				outfile.close();
//				System.out.print("file Decrypted");
//			} catch (Exception e) {
//				System.out.print(e);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//			System.out.print(e);
//		}
//
//	}
//
//}
