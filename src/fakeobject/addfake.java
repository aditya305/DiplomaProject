package fakeobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class addfake {
	public static void main(String args[]) throws IOException{

		File a = new File("C:\\Users\\Sumit\\Desktop\\Enhance-E-Learning - Copy.rar");
		Properties props = new Properties();
		props.setProperty("host", "www.codejava.net");
		String host = props.getProperty("host");
		System.out.println(host);
	}
}
