package fakeobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Signature {


    public void addSignature(String infile, String outfile, String message) {
        try {
            File file = new File(infile);
            //Instantiate the input stread
            InputStream insputStream = new FileInputStream(file);
            long length = file.length();

            byte[] inFileByte = new byte[(int) length];
            insputStream.read(inFileByte);
            insputStream.close();

            String userdata =  message;
            System.out.println(userdata.length());

            byte[] len = new byte[500];
            String ss = userdata + "";

            if (ss.length() < 500) {
                ss = ss + "@";
            }

            for (int i = 0; i < ss.length(); i++) {
                len[i] = (byte) ss.charAt(i);
            }

            //System.out.println("IN : "+inFileByte.length+"  Key : "+len.length);
            byte[] combined = new byte[inFileByte.length + len.length];

            System.arraycopy(inFileByte, 0, combined, 0, inFileByte.length);
            System.arraycopy(len, 0, combined, inFileByte.length, len.length);

            FileOutputStream fos = new FileOutputStream(outfile);
            fos.write(combined);
            fos.flush();
            fos.close();

        } catch (Exception e) {
        }
    }

    public String getSignature(String infile) {
        String watermarkdata = "";
        try {
            File file = new File(infile);
            //Instantiate the input stread
            InputStream insputStream = new FileInputStream(file);
            long length = file.length();

            byte[] inFileByte = new byte[(int) length];
            insputStream.read(inFileByte);
            insputStream.close();

            int len = inFileByte.length - 500;

            String ss = "";

            for (int i = len; i < inFileByte.length; i++) {
                ss = ss + (char) inFileByte[i];
            }

            for (int i = 0; i < 500; i++) {
                if (ss.charAt(i) == '@') {
                    ss = ss.substring(0, i);
                    break;
                }
            }
            watermarkdata = ss;
        } catch (Exception e) {
        }
        return watermarkdata;
    }

//    public static void addsign(String image, String message) {
//    	Signature sign = new Signature();
//        sign.addSignature(image, message);
//    }
    
//    public static String[] removesign(String image) {
//    	Signature sign = new Signature();
//    	String str = sign.getSignature(image);
//        String[] counter = str.split("\\$", -1);
//		return counter;
//    }
    
//    public static void main(String[] args) {
//        Signature sign = new Signature();
//        sign.addSignature("C:/Users/Sumit/Desktop/Enc_banner1.jpg", "sumit");
//
//        String str = sign.getSignature("C:/Users/Sumit/Desktop/Enc_banner1.jpg");
//        System.out.println(str);
//    }
}
