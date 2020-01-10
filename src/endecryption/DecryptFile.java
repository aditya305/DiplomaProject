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

public class DecryptFile {

    KeyGenerator keyGenerator = null;
    SecretKey secretKey = null;
    Cipher cipher = null;
    String masterPassword = null;
    public String instance = "Blowfish";

    public DecryptFile(String masterPassword) {
        this.masterPassword = masterPassword;
        try {
            keyGenerator = KeyGenerator.getInstance(instance);
            secretKey = new SecretKeySpec(masterPassword.getBytes(), instance);
            cipher = Cipher.getInstance(instance);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }

    public void decrypt(String srcPath, String destpath) {
        File encryptedFile = new File(srcPath);
        File decryptedFile = new File(destpath);

//        JFileChooser chooser = new JFileChooser();
//        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
//        int result = chooser.showSaveDialog(frm);
//        if (result == JFileChooser.CANCEL_OPTION) {
//            return;
//        }
//        File temp = chooser.getSelectedFile();
//        if (temp.getName().equals("")) {
//            JOptionPane.showMessageDialog(frm, "Invalid File Name", "Invalid File Name", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        File decryptedFile = new File(temp.getPath() + "." + srcPath.substring(srcPath.lastIndexOf(".") + 1));
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            inStream = new FileInputStream(encryptedFile);
            outStream = new FileOutputStream(decryptedFile);
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
            br = new BufferedReader(new FileReader(decryptedFile));
            String str;

            while ((str = br.readLine()) != null) {
                print = print + str + "\n";
            }
            outStream.write(cipher.doFinal());
            inStream.close();
            
            outStream.close();
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public static void main(String[] args) {
        DecryptFile dec = new DecryptFile("key");
        dec.decrypt("C:\\Users\\Mahendra\\Desktop\\red1.jpg", "C:\\Users\\Mahendra\\Desktop\\red11.jpg");
    }
}
