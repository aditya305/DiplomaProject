package endecryption;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncryptFile {

    KeyGenerator keyGenerator = null;
    static SecretKeySpec secretKey = null;
    static Cipher cipher = null;
    String masterPassword = null;
    public String instance = "Blowfish";

    public EncryptFile(String masterPassword) {
        this.masterPassword = masterPassword;
    	this.masterPassword = "My Key";
        try {
            keyGenerator = KeyGenerator.getInstance(instance);
            secretKey = new SecretKeySpec(masterPassword.getBytes(), instance);
            cipher = Cipher.getInstance(instance);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }

    public static String encrypt(String srcPath ,String destpath) {
        File srcFile = new File(srcPath);
        File encryptedFile = new File(destpath);
//        File encryptedFile = new File("./encryptfiles/" + rawFile.getName());
        //String blowfishkey=EncryptFile.secretKey;
                
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            inStream = new FileInputStream(srcFile);
            outStream = new FileOutputStream(encryptedFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inStream.read(buffer)) > 0) {
                outStream.write(cipher.update(buffer, 0, len));
                outStream.flush();
            }
            BufferedReader br = null;
            outStream.write(cipher.doFinal());
            inStream.close();
            outStream.close();
            String print = "";
            br = new BufferedReader(new FileReader(encryptedFile));
            String str;
            while ((str = br.readLine()) != null) {
                print = print + str + "\n";
            }
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
		return destpath;
    }

    public static void main(String[] args) {
        EncryptFile enc = new EncryptFile("key");
        enc.encrypt("C:\\Users\\Mahendra\\Desktop\\red.jpg","C:\\Users\\Mahendra\\Desktop\\red1.jpg");
    }
}
